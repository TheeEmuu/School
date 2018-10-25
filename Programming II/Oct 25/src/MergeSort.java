public class MergeSort {
    public static int[] mergeSort(int[] array){
        //return(mergeSort(array, 0, array.length));
        if(array.length == 1)
            return array;

        int middle = (array.length)/2;
        int[] a = new int[middle];
        int[] b = new int[array.length - middle];

        System.arraycopy(array, 0, a, 0, middle);
        System.arraycopy(array, middle, b, 0, array.length - middle);

        a = mergeSort(a);
        b = mergeSort(b);

        return(merge(a,b));
    }

    private static int[] merge(int[] a, int[] b){
        //make an array to hold the sorted array
        int[] temp = new int[a.length + b.length];

        //create pointers
        int right = 0;
        int left = 0;
        int index = 0;

        //sort while there neither array is empty
        while (left < a.length && right < b.length){
            if(a[left] <= b[right]){
                temp[index] = a[left];
                left++;
            }
            else{
                temp[index] = b[right];
                right++;
            }

            index++;
        }

        //either a or b may have leftover values
        while(left < a.length){
            temp[index] = a[left];
            index++;
            left++;
        }
        while(right < b.length){
            temp[index] = b[right];
            index++;
            right++;
        }

        return temp;
    }

    public static void main(String[] args){
        int[] array = new int[] {2};

       array =  mergeSort(array);

       for(int i = 0; i < array.length; i++){
           System.out.print(array[i]);
       }
    }
}
