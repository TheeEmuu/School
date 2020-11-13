import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.function.Function;

public class trapezoid {
    static double[] trapAreas;
    static Function<Double, Double> fun;
    static double intervalSize;

    public static void main(String[] args) {
        int a = 0;
        int b = 1000;
        double[] integrals = integrate(a, b, 5000, (n) -> n * n);

        Scanner in = new Scanner(System.in);
        int aIn = (in.nextInt() - (a+1)) * (int)(1/intervalSize);
        int bIn = (in.nextInt() - (a+1)) * (int)(1/intervalSize);

        if(aIn >= 0)
            System.out.println(integrals[bIn] - integrals[aIn]);
        else
            System.out.println(integrals[bIn]);

        in.close();
    }

    public static double[] integrate(double a, double b, int N, Function<Double, Double> f){
        trapAreas = new double[N];
        fun = f;
        intervalSize = (b - a) / N;

        ForkJoinPool pool = ForkJoinPool.commonPool();
        pool.invoke(new Map(a, b, N));
        SScan scan = new SScan(trapAreas, 100);
        scan.parallelRecursiveScan();
        double[] ret = scan.getScans();
        return ret;
    }

    private static class Map extends RecursiveAction{
        double a;
        double b;
        int N;

        final int THRESHOLD = 100;

        Map(double a, double b, int N){
            this.a = a;
            this.b = b;
            this.N = N;
        }

        @Override
        protected void compute() {
            if(N < THRESHOLD){
                serialMap();
            }else{
                double mid;
                Map left;
                Map right;

                if(N % 2 == 0){
                    mid = a + (N/2) * intervalSize;
                    left = new Map(a, mid, N/2);
                    right = new Map(mid, b, N/2);
                } else{
                    mid = a + (N/2 + 1) * intervalSize;
                    left = new Map(a, mid, N/2 + 1);
                    right = new Map(mid, b, N/2);
                }

                left.fork();
                right.compute();
                left.join();
            }
        }

        void serialMap(){
            int offset = (int)((a / intervalSize) - a);
            try{
                for(int i = offset; i < offset + N; i++){
                    trapAreas[i] = (fun.apply(a) + fun.apply(a + intervalSize)) * intervalSize / 2;
                    a += intervalSize;
                }
            } catch(ArrayIndexOutOfBoundsException e){}
        }
    }
}

class SScan {
    private double[] data;
    private int tileSize;

    private double[] r;
    private double[] scans;

    public SScan(double[] data, int tileSize) {
        this.data = data;
        this.tileSize = tileSize;
    }

    public double[] getScans() {
        return scans;
    }

    public void parallelRecursiveScan(){
        int m = 1 + (data.length - 1)/tileSize;

        r = new double[m];
        scans = Arrays.copyOf(data, data.length); // we could overwrite the original, or make a copy.

        ForkJoinPool pool = ForkJoinPool.commonPool();

        pool.invoke(new UpSweep(0, m));
        pool.invoke(new DownSweep(0, m, 0));
    }

    private int split(int m) {
        return Integer.highestOneBit(m-1);
    }

    private double tileReduce(int start) {
        int end = start + tileSize <= data.length ? start+tileSize : data.length;
        double r = 0.0;
        for (int i=start; i<end; ++i)
            r += slow(data[i]);
        return r;
    }

    private void tileScan(int start, double initial) {
        int end = start + tileSize <= data.length ? start+tileSize : data.length;

        scans[start] = slow(scans[start]) + initial;
        for (int i=start+1; i<end;++i)
            scans[i] = slow(scans[i]) + scans[i-1];
    }

    // this is here to artifically increase the computational intensity
    private double slow(double d) {
        double d2 = d;
        while (d2 > 0) {
            d2 -= 300000;
        }
        return d;
    }

    class UpSweep extends RecursiveAction{
        int start;
        int numTiles;

        UpSweep(int start, int numTiles){
            this.start = start;
            this.numTiles = numTiles;
        }

		@Override
		protected void compute() {
            if (numTiles == 1) {
                // base case. Compute a reduction over the ith tile.
                r[start] = tileReduce(start*tileSize);
            }
            else {
                int k = split(numTiles);
                UpSweep left = new UpSweep(start, k);
                UpSweep right = new UpSweep(start+k, numTiles-k);
                left.fork();

                right.compute();
                left.join();
    
                if (numTiles == 2*k) {
                    r[start+numTiles-1] = r[start+k-1] + r[start+numTiles-1];
                }
            }
        }
    }

    class DownSweep extends RecursiveAction{
        int start;
        int numTiles;
        double initial;

        DownSweep(int start, int numTiles, double initial) {
            this.start = start;
            this.numTiles = numTiles;
            this.initial = initial;
        }
		@Override
		protected void compute() {
			if (numTiles == 1) {
                // base case; compute the scan over the ith tile
                tileScan(start*tileSize, initial);
            }
            else {
                int k = split(numTiles);
                DownSweep left = new DownSweep(start, k, initial);
                left.fork();
                initial = initial + r[start+k-1];
                DownSweep right = new DownSweep(start+k, numTiles-k, initial);
                right.compute();
                left.join();
            }
		}
    }
}