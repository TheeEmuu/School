import java.util.Arrays;
import java.util.Random;

public class TestSorts {

	// generate an array of size size, with entries from 0...hi-1
	static int[] randomArray(int size, int hi) {
		Random r = new Random();
		
		int[] arr = new int[size];
		for (int i=0; i<arr.length; ++i) {
			arr[i] = r.nextInt(hi);
			if (r.nextBoolean())
			    arr[i] = -arr[i];
		}
		return arr;
	}
	

	static int[] sortedArray(int size) {
		int[] arr = new int[size];
		for (int i=0; i<arr.length; ++i) {
			arr[i] = i;
		}
		return arr;
	}
	
	static int[] reverseSortedArray(int size) {
		int[] arr = new int[size];
		for (int i=0; i<arr.length; ++i) {
			arr[i] = arr.length - i;
		}
		return arr;
	}
	
	
	static int[] allEqualArray(int size) {
		int[] arr = new int[size];
		for (int i=0; i<arr.length; ++i) {
			arr[i] = 42;
		}
		return arr;
	}
	
	
	static boolean isSorted(int[] arr) {
		for (int i=1; i<arr.length; ++i) 
			if (arr[i] < arr[i-1])
				return false;
		return true;
	}

	static void print(int[] arr) {
	    for (int i=0; i<arr.length; ++i) {
            System.out.printf("%3d: %6d\n",i,arr[i]);
        }
    }
	
	public static void main(String[] args) {
		final double CONVERT = 1_000_000.0;
		final int SIZE = 100_000_000;
		final int TRIALS = 10;

//        System.out.printf("%12s %12s %12s %12s\n","size", "bin1 (ms)", "bin2 (ms)", "bin3 (ms)");
//        for (int sz = 10; sz <= SIZE; sz *= 10) {
//            int[] bin1 = randomArray(sz, 300);
//			int[] bin2 = Arrays.copyOf(bin1, bin1.length);
//			int[] bin3 = Arrays.copyOf(bin1, bin1.length);
//            long time1 = System.nanoTime();
//            //Binning.bin1(bin1);
//            long time2 = System.nanoTime();
//			Binning.bin2(bin2);
//			long time3 = System.nanoTime();
//			Binning.bin3(bin3);
//			long time4 = System.nanoTime();
//            System.out.printf("%,12d %,12.1f %,12.1f %,12.1f\n", sz,
//					(time2 - time1) / CONVERT, (time3 - time2) / CONVERT, (time4 - time3) / CONVERT);
//        }

        System.out.printf("%12s %12s %12s\n", "Size", "System", "Quick");
		for (int sz=10; sz<=SIZE; sz *= 10) {
			int[] a = randomArray(sz, sz/3);
//			int[] a = reverseSortedArray(sz);
//			int[] a = sortedArray(sz);
			int[] b = Arrays.copyOf(a, a.length);
			
			long time1 = System.nanoTime();
			Arrays.sort(b);
			long time2 = System.nanoTime();
			Sorting.quickSort(a);
			long time3 = System.nanoTime();
			if (!isSorted(b))
				System.out.println("Bubble Sort failed!");
			if (!isSorted(a))
				System.out.println("Quick Sort failed!");
			
			System.out.printf("%,12d %,12.1f %,12.1f\n", sz, (time2 - time1)/CONVERT, (time3 - time2)/CONVERT);
			
		}
	}
}
