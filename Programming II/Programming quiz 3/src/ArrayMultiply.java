public class ArrayMultiply {
    public static int[] products(int[] a){
        //pre: a is an array of integers
        //post: returns an array where each item is the product of every integer except the integer at that index

        //TOTAL RUNTIME: 3C+ N*((N-i)+(N - (N+i))) = O(n^2)

        //RUNTIME: Constant
        int[] array = new int[a.length];
        int product = 1;

        //i is the index
        //i increases
        //RUNTIME: N
        for(int i = 0; i < a.length; i++){
            //checks above i and multiplies everything
            //RUNTIME: N - i
            for(int k = i + 1; k < a.length; k++ ){
                product = product * a[k];
            }

            //checks below i and multiplies everything
            //RUNTIME: N - (N + i)
            for(int k = i - 1; k >= 0; k--){
                product = product * a[k];
            }

            //RUNTIME: Constant
            array[i] = product;
            product = 1;
        }

        //RUNTIME: Constant
        return array;
    }

    public static void main(String[] args){
        int[] array = new int[]{1,7,3,4};

        array = products(array);

        for (int x : array) {
            System.out.println(x);
        }
    }
}
