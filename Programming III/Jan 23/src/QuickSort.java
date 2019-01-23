public class QuickSort {
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
            while (left < right && data[left].compareTo(data[right]) < 0) right--;
            if (left < right) swap(data,left++,right);
            else return left;
            // move left pointer toward right
            while (left < right && data[left].compareTo(data[right]) < 0) left++;
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
        String[] array = new String[]{"c", "b", "g", "e", "a", "d","f"};
        for (String x:array) {
            System.out.print(x + " ");
        }
        System.out.println();

        quickSort(array, array.length);

        for (String x:array) {
            System.out.print(x + " ");
        }
        System.out.println();
    }
}
