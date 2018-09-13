public class RatioPi {
    public static void main(String [] args) {
        Ratio ratio;
        double total = 0;
        int a;
        int b;

        int iterations = 10000;
        for (int i = 0; i < iterations; i++) {
            a = (int)(Math.random() * 10);
            b = (int)(Math.random() * 10);

            ratio = new Ratio(a,b);

            if (a == ratio.getNumerator() && b == ratio.getDenominator()){
                total++;
            }
        }

        //Calculate experimental probability
        total = total / iterations;
        //Use true probability to estimate pi
        total = Math.sqrt((1/(total / 6)));

        System.out.println(total);
    }
}
