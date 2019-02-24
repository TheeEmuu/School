public class Bin {
    public static void swap(String data[], int i, int j)
    // pre: 0 <= i,j < data.length
    // post: data[i] and data[j] are exchanged
    {
        String temp;
        temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    public static void binSort(int data[]){
        int temp1, temp2;
        for(int i = 0; i < data.length; i++){
            if(data[i] > 0 && data[i] < 100) {
                temp1 = data[i];

            }
        }
    }

    public static void main(String[] args){
        int array[] = new int[]{-1,23,6,-43,105,0,215,-23,-111,14,5};

        for(int x:array){
            System.out.print(x + " ");
        }
        System.out.println();

        binSort(array);

        for(int x:array){
            System.out.print(x + " ");
        }
    }
}
