import java.util.ArrayList;

public class Binning {
    public static final int CUT1 = 0;
    public static final int CUT2 = 100;

    public static void bin1(int[] arr) {
        ArrayList<Integer> binA = new ArrayList<>();
        ArrayList<Integer> binB = new ArrayList<>();
        ArrayList<Integer> binC = new ArrayList<>();

        for (int i=0; i<arr.length; ++i) {
            if (arr[i] < 0)
                binA.add(arr[i]);
            else if (arr[i] < 100)
                binB.add(arr[i]);
            else
                binC.add(arr[i]);
        }

        int idx = 0;
        for (int a : binA) {
            arr[idx++] = a;
        }
        for (int b : binB) {
            arr[idx++] = b;
        }
        for (int c : binC) {
            arr[idx++] = c;
        }
    }

    public static void bin2(int[] arr) {
        int pivot = partition(arr, 0, arr.length-1, 0);
        partition(arr, pivot, arr.length-1, 100);
    }

    public static void bin3(int[] arr) {
        int idx = 0;
        for (int i=0; i<arr.length; ++i) {
            if (arr[i] < 0)
                swap(arr, i, idx++);
        }

        for (int i=idx; i < arr.length; ++i) {
            if (arr[i] < 100)
                swap(arr, i, idx++);
        }
    }

    // grabbed partition from the quicksort code and modified it to do my job
    private static int partition(int[] array, int left, int right, int pVal) {
        // like qsort partition, but use pVal
        int below = left-1;
        int above = right+1;
        while (true) {
            // step 1: move below up as far as possible.  Why do we have to test for below < above?
            do {
                below++;
            } while (below < above && array[below] < pVal);


            // step 2: move above down as far as possible.  Why DON'T we test for above > below?
            do {
                above--;
            } while (array[above] > pVal);

            // if there is space between above and below, we have found two elements that
            // we should swap.  If above and below have met, then we are done, there are
            // no more items out of position.
            if (below < above)
                swap(array, below, above);
            else
                break;

            // post: above and below are closer together.  Halt when above >= below
        }

        // finally, put the pivot into position.  Note that above always points at a
        // valid spot for the pivot, since it went down past all larger elements.
        return above+1;

    }

    private static void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

}
