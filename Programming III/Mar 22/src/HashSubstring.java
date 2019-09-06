public class HashSubstring {
    private static boolean equalHash(int a, int b){
        return a == b;
    }

    public static boolean containsSubstring(String string, String substring){
        int substringLength = substring.length();
        int substringHash = substring.hashCode();

        for(int i = 0; i < string.length() - substringLength; i++){
            String sub = string.substring(i, i+substringLength);
            int stringHash = sub.hashCode();

            if(equalHash(stringHash, substringHash))
                if(sub.equals(substring))
                    return true;
        }

        return false;
    }

    public static void main(String[] args){
        long startTime, endTime;

        startTime = System.nanoTime();
        System.out.println(containsSubstring("AAbbCCdddd", "Ab"));
        endTime = System.nanoTime();
        System.out.println("Execution time: " + (endTime - startTime) + " nanoseconds\n");

        startTime = System.nanoTime();
        System.out.println(containsSubstring("The quick brown fox jumped over the lazy dog", "laz"));
        endTime = System.nanoTime();
        System.out.println("Execution time: " + (endTime - startTime) + " nanoseconds\n");

        startTime = System.nanoTime();
        System.out.println(containsSubstring("The quick brown fox jumped over the lazy dog", "cat"));
        endTime = System.nanoTime();
        System.out.println("Execution time: " + (endTime - startTime) + " nanoseconds\n");
    }
}
