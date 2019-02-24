public class QuickSort {
    private static int comparisons;

    public static void swap(String data[], int i, int j)
    // pre: 0 <= i,j < data.length
    // post: data[i] and data[j] are exchanged
    {
        String temp;
        temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    private static int partition(String data[], int left, int right)
    // pre: left <= right
    // post: data[left] placed in the correct (returned) location
    {
        while (true)
        {
            // move right "pointer" toward left
            while (left < right && data[left].compareTo(data[right]) < 0) right--; comparisons++;
            if (left < right) swap(data,left++,right);
            else return left;
            // move left pointer toward right
            while (left < right && data[left].compareTo(data[right]) < 0) left++; comparisons++;
            if (left < right) swap(data,left,right--);
            else return right;
        }
    }

    public static void quickSort(String data[], int n)
    // post: the values in data[0..n-1] are in ascending order
    {
        quickSortRecursive(data,0,n-1);
    }

    private static void quickSortRecursive(String data[],int left,int right)
    // pre: left <= right
    // post: data[left..right] in ascending order
    {
        int pivot; // the final location of the leftmost value
        if (left >= right) return;

        pivot = partition(data,left,right); /* 1 - place pivot */
        quickSortRecursive(data,left,pivot-1); /* 2 - sort small */
        quickSortRecursive(data,pivot+1,right);/* 3 - sort large */
        /* done! */
    }

    public static void main(String[] args){
        //String array[] = new Randoms().randomStringArray(50, 100);
        String array[] = new String[]{"a", "b", "c", "d", "e", "f", "g"};
        long start = System.nanoTime();
        quickSort(array, array.length);
        long end = System.nanoTime();

        for (String x:array) {
            System.out.print(x + " ");
        }
        System.out.println();
        System.out.println("COMPARISONS: " + comparisons);
        System.out.println("TIME: " + (end - start));
    }
}
