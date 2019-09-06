public class Main {
    public static void main(String[] args){
        HeapPriorityQueue<Integer> queue = new HeapPriorityQueue<>();

        queue.add(1);
        queue.add(5);
        queue.add(4);
        queue.add(3);
        queue.add(7);
        queue.add(2);

        System.out.println("Removed " + queue.remove(2));
        System.out.println("Removed " + queue.remove(1));

        while(queue.size() > 0){
            System.out.println(queue.remove());
        }
    }
}
