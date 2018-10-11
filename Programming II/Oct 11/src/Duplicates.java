public class Duplicates {
    private static final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    public static String[] RandomStrings(int n){
        String[] strings = new String[n];

        for(int i = 0; i < n; i++) {
            String string = "";
            for (int k = 0; k < 5; k++) {
                string = string + ALPHA_NUMERIC_STRING.charAt((int) (Math.random() * ALPHA_NUMERIC_STRING.length()));
            }
            strings[i] = string;
        }

        return strings;
    }

    public static void main(String[] args){
        String[] strings;
        for(int i = 10; i < 10000000; i = i*10){
            strings = RandomStrings(i);
            Stopwatch stopwatch = new Stopwatch();

            stopwatch.start();
            int count = 0;
            for (int k = 0; k < strings.length; k++) {
                for (int j = k + 1; j < strings.length; j++) {
                    if (strings[k].equals(strings[j]))
                        count++;
                }
            }
            Double duration = stopwatch.stop();

            System.out.println(i + " itterations: " + duration);
        }
    }
}
