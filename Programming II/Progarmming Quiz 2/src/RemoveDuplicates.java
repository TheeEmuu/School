import structure.SetVector;

public class RemoveDuplicates {
    public static SetVector removeDuplicates(int[] list1){
        SetVector list2 = new SetVector();

        for(int i = 0; i < list1.length; i++){
            list2.add(list1[i]);
        }

        return list2;
    }

    public static void main(String[] args){
        int[] list = new int[5];

        list[0] = 1;
        list[1] = 2;
        list[2] = 2;
        list[3] = 2;
        list[4] = 3;

        System.out.println(list);
        System.out.println(removeDuplicates(list));
    }
}
