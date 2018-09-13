public class ArrayMaker {
    public static int[] array(int num){
        int [] array = new int[num];

        for(int i = 0; i < array.length; i++){
            array[i] = (int)(999 * Math.random() + 1);
        }

        return array;
    }

    public static void main(String[] args){
        int num;
        int[] array;

        System.out.print("Please input an array length: ");
        num = TextIO.getlnInt();

        array = array(num);

        for (int i = 0; i < array.length; i++){
            System.out.println(array[i]);
        }
    }
}
