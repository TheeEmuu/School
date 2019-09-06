package lvc.cds.DS;

import java.util.ArrayList;
import java.util.Comparator;

import static java.util.Comparator.naturalOrder;

public class ArraySet<E extends Comparable<E>> implements Set<E> {
    private ArrayList<E> data;
    private Comparator<E> comp;

    /**
     * initialize an empty container. Use the default "natural" comparator (i.e.,
     * the one that uses the class's compareTo())
     *
     * @post array is sorted (trivally, in this case)
     */
    public ArraySet() {
        data = new ArrayList<>();
        comp = Comparator.naturalOrder();
    }

    /**
     * initialize an empty container. Use the default "natural" comparator (i.e.,
     * the one that uses the class's compareTo())
     *
     * @post array is sorted (trivally, in this case)
     */
    public ArraySet(Comparator<E> c) {
        data = new ArrayList<>();
        comp = c;
    }

    /**
     * @param e an element to search for
     * @return true if an element that compares equal to e is present, false otherwise.
     */
    @Override
    public boolean contains(E e) {
        return (find(e) != -1);
    }

    /**
     * Insert e into the container. What should be done if e is null? What should be done if an
     * element equal to e is present?
     * <p>
     * pre: the array is in sorted order
     * post: the array is in sorted order. size(pre) + 1 == size(post). contains(e) == true
     *
     * @param e an element to add to the container.
     */
    @Override
    public void add(E e) {
        // place e at end of the array.
        data.add(e);

        // insertion-sort it into the right spot
        int pos = data.size()-2;
        while (pos >= 0 && comp.compare(e, data.get(pos)) < 0) {
            data.set(pos+1, data.get(pos));
            pos--;
        }
        data.set(pos+1, e);
    }

    /**
     * if an element that compares equal to e is present, remove it. What should be done if e
     * appears multiple times?
     * <p>
     * pre: the array is in sorted order
     * post: The array is in sorted order. size(post) == size(pre) || size(post) == size(pre) - 1.
     * The number of elements that compare equal to e == 0 or it has been reduced by 1.
     *
     * @param e an element to remove, if present.
     */
    @Override
    public void remove(E e) {
        int pos = find(e);
        if (pos == -1)
            return;
        else
            data.remove(pos);
    }

    /**
     * @return the number of elements in the container
     */
    @Override
    public int size() {
        return data.size();
    }

    /**
     * return true if there are no elements, false otherwise.
     */
    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    private int find(E e) {
        int left = 0;
        int right = data.size()-1;

        // exercise: prove using induction that this loop always stops.
        while (true) {
            int mid = (left + right)/2;
            int cmp = comp.compare(e, data.get(mid));

            if (cmp == 0)  // found it
                return mid;

            if (left >= right) // didn't find it
                return -1;
            else if (cmp < 0)    // keep looking
                right = mid - 1;
            else
                left = mid + 1;
        }
    }

    void print() {
        for (E e : data)
            System.out.println(e);
    }

    boolean checkInvariant() {
        for (int i=0; i < data.size() - 1; ++i) {
            if (data.get(i+1).compareTo(data.get(i)) < 0)
                return false;
        }
        return true;
    }

    E get(int idx) {
        return data.get(idx);
    }

    int numEqual(E e) {
        int cnt = 0;
        for (E d : data) {
            if (e.compareTo(d) == 0)
                cnt++;
        }
        return cnt;
    }
}
