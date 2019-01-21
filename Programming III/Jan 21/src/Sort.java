public class Sort {
    public static int bubbleComparisons = 0;
    public static int insertComparisons = 0;

    public static void swap(String data[], int i, int j)
    // pre: 0 <= i,j < data.length
    // post: data[i] and data[j] are exchanged
    {
        String temp;
        temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    public static void bubbleSort(String data[], int n){
        int numSorted = 0;
        int index;
        while (numSorted < n){
            for (index = 1; index < n-numSorted; index++){
                bubbleComparisons++;
                if(data[index-1].compareTo(data[index]) > 0)
                    swap(data, index-1, index);
            }

            numSorted++;
        }
    }

    public static void insertionSort(String data[], int n){
        int numSorted = 1;
        int index;
        while (numSorted < n){
            String temp = data[numSorted];

            for(index = numSorted; index > 0; index--){
                if(temp.compareTo(data[index-1]) < 0) {
                    data[index] = data[index - 1];
                    insertComparisons++;
                }
                else {
                    insertComparisons++;
                    break;
                }
            }

            data[index] = temp;
            numSorted++;
        }
    }

    public static void main(String[] args){
        String list[] = new Randoms().randomStringArray(200, 100);
        String list2[] = new Randoms().randomStringArray(200, 100);

        long start = System.nanoTime();
        bubbleSort(list, list.length);
        long end = System.nanoTime();
        long bubbleSortDuration = (end - start);

        start = System.nanoTime();
        insertionSort(list2, list2.length);
        end = System.nanoTime();
        long insertSortDuration = (end - start);

        for (String x:list) {
            System.out.print(x + " ");
        }
        System.out.println();
        System.out.println("COMPARISONS: " + bubbleComparisons);
        System.out.println("TIME: " + bubbleSortDuration);

        System.out.println("\n");

        for(String x:list2){
            System.out.print(x + " ");
        }
        System.out.println();
        System.out.println("COMPARISONS: " + insertComparisons);
        System.out.println("TIME: " + insertSortDuration);
    }
}
