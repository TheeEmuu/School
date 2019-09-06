import java.util.Stack;
import java.util.Vector;

public class HeapPriorityQueue<E extends Comparable<E>> {
    protected Vector<E> data; // the data, kept in heap order

    public HeapPriorityQueue(){
        // post: constructs a new priority queue
        data = new Vector<E>();
    }

    public HeapPriorityQueue(Vector<E> v){
        // post: constructs a new priority queue from an unordered vector
        int i;
        data = new Vector<E>(v.size()); // we know ultimate size
        for (i = 0; i < v.size(); i++)
        { // add elements to heap
            add(v.get(i));
        }
    }

    protected static int parent(int i){
        // pre: 0 <= i < size
        // post: returns parent of node at location i
        return (i-1)/2;
    }

    protected static int left(int i){
        // pre: 0 <= i < size
        // post: returns index of left child of node at location i
        return 2*i+1;
    }

    protected static int right(int i){
        // pre: 0 <= i < size
        // post: returns index of right child of node at location i
        return 2*(i+1);
    }

    protected void percolateUp(int leaf){
        // pre: 0 <= leaf < size
        // post: moves node at index leaf up to appropriate position
//        int swaps = 0;

        int parent = parent(leaf);
        E value = data.get(leaf);
        while (leaf > 0 &&
                (value.compareTo(data.get(parent)) < 0))
        {
//            swaps++;
            data.set(leaf,data.get(parent));
            leaf = parent;
            parent = parent(leaf);
        }
//        System.out.println("Performed " + swaps + " swaps");
        data.set(leaf,value);
    }

    public void add(E value){
        // pre: value is non-null comparable
        // post: value is added to priority queue
        data.add(value);
        percolateUp(data.size()-1);
    }

    protected void pushDownRoot(int root){
        // pre: 0 <= root < size
        // post: moves node at index root down
        // to appropriate position in subtree
        int heapSize = data.size();
        E value = data.get(root);
        while (root < heapSize) {
            int childpos = left(root);
            if (childpos < heapSize)
            {
                if ((right(root) < heapSize) &&
                        ((data.get(childpos+1)).compareTo
                                (data.get(childpos)) < 0))
                {
                    childpos++;
                }
                // Assert: childpos indexes smaller of two children
                if ((data.get(childpos)).compareTo
                        (value) < 0)
                {
                    data.set(root,data.get(childpos));
                    root = childpos; // keep moving down
                } else { // found right location
                    data.set(root,value);
                    return;
                }
            } else { // at a leaf! insert and halt
                data.set(root,value);
                return;
            }
        }
    }

    public E remove(){
        // pre: !isEmpty()
        // post: returns and removes minimum value from queue
        E minVal = data.get(0);
        data.set(0,data.get(data.size()-1));
        data.setSize(data.size()-1);
        if (data.size() > 1) pushDownRoot(0);
        return minVal;
    }

    public E remove(int pos){
        E value = data.get(pos);
        data.set(pos, null);

        data.set(pos, data.remove(data.size() -1));
        if(data.get(parent(pos)).compareTo(data.get(pos)) > 0){
            percolateUp(pos);
        }
        else
            pushDownRoot(pos);

        return value;
    }

    public int size() {return data.size();}

    public boolean testHeapProperty(){
        return testHeapProperty(0);
    }
    private boolean testHeapProperty(int root){
        Stack<Integer> todo = new Stack<>();

        todo.push(root);

        //checks all nodes to see if their children are too big
        //O(n)
        while(!todo.isEmpty()){
            int cur = todo.pop();

            if(data.get(left(cur)) != null)
                todo.push(left(cur));
            if(data.get(right(cur)) != null)
                todo.push(left(cur));

            //root is larger than one of it's children, which doesn't satisfy the heap condition;
            if(data.get(cur).compareTo(data.get(left(cur))) < 0 ||
                    data.get(cur).compareTo(data.get(right(cur))) < 0)
                return false;
        }

        //If one subtree is too much taller than the other, the heap property is not satisfied
        //O(n)
        if(height(left(root)) > height(right(root)) + 1 || height(left(root)) < height(right(root)))
            return false;

        //If both of these are satisfied, we have a heap
        return true;

        //Runs in O(n) time
    }

    private int height(int root){
        if(data.get(left(root)) == null && data.get(right(root)) == null)
            return 1;
        return Math.max(height(left(root)), height(right(root)));
    }
}
