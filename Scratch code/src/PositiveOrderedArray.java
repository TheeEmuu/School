import java.util.Arrays;

public class PositiveOrderedArray {
    public static void main(String[] args){
        int[] array = processArray(new int[]{6,15,-97,486,-1,-8,15,68,32,12,88,1});
        String stringArray = Arrays.toString(array);
        System.out.println(stringArray);
    }

    public static int[] processArray(int[] inputArray){
        int processedIndex = 0;

        int[] temp = new int[inputArray.length];
        //region Make temp the positive values of inputArray
        for(int value : inputArray){
            if(value > 0){
                temp[processedIndex] = value;
                processedIndex++;
            }
        }
        //#endregion

        int[] processedArray = new int[processedIndex];
        //region Shrink temp to processedArray, discarding unused indexes
        //noinspection ManualArrayCopy
        for(int i = 0; i < processedIndex; i++){
            processedArray[i] = temp[i];
        }
        //#endregion

        Arrays.sort(processedArray);

        return processedArray;
    }
}
