// Implementation of lists, using singly linked elements.
// (c) 1998, 2001 duane a. bailey

package structure;
import java.util.Iterator;
import java.util.Enumeration;
/**
 * Singly linked lists have elements connected by a single reference.
 * They are space-efficient, but tail-related operations may be more
 * costly than with doubly linked lists.
 *
 * @version $Id: SinglyLinkedList.java 31 2007-08-06 17:19:56Z bailey $
 * @author, 2001 duane a. bailey
 * @see DoublyLinkedList
 */
public class SinglyLinkedList extends AbstractList
{
    /**
     * The number of elements in list.
     */
    protected int count;                    // list size
    /**
     * The head of the list.  A reference to a singly linked list element.
     */
    protected Node head; // ref. to first element

    /**
     * Construct an empty list.
     *
     * @post generates an empty list
     */
    public SinglyLinkedList()
    {
        head = null;
        count = 0;
    }

    /**
     * Add an object to tail of list.
     *
     * @post value is added to end of list (see addLast)
     * 
     * @param value The value to be added to tail of list.
     * @see #addToHead
     */
    public void add(Object value)
    {
        addLast(value);
    }
    
    /**
     * Add a value to head of list.
     *
     * @post value is added to beginning of list
     * 
     * @param value The value to be added to head of list.
     */
    public void addFirst(Object value)
    {
        // note order that things happen:
        // head is parameter, then assigned
        head = new Node(value, head);
        count++;
    }

    /**
     * Remove a value from first element of list.
     *
     * @pre list is not empty
     * @post removes and returns value from beginning of list
     * 
     * @return The value actually removed.
     */
    public Object removeFirst()
    {
        Node temp = head;
        head = head.next(); // move head down list
        count--;
        return temp.value();
    }

    /**
     * Add a value to tail of list.
     *
     * @post adds value to end of list
     * 
     * @param value The value to be added to tail of list.
     */
    public void addLast(Object value)
    {
        // location for new value
        Node temp = new Node(value,null);
        if (head != null)
        {
            // pointer to possible tail
            Node finger = head;
            while (finger.next() != null)
            {
                finger = finger.next();
            }
            finger.setNext(temp);
        } else head = temp;
        count++;
    }

    /**
     * Remove last value from list.
     *
     * @pre list is not empty
     * @post removes last value from list
     * 
     * @return The value actually removed.
     */
    public Object removeLast()
    {
        Node finger = head;
        Node previous = null;
        while (finger.next() != null) // find end of list
        {
            previous = finger;
            finger = finger.next();
        }
        // finger is null, or points to end of list
        if (previous == null)
        {
            // has exactly one element
            head = null;
        }
        else
        {
            // pointer to last element is reset
            previous.setNext(null);
        }
        count--;
        return finger.value();
    }

    /**
     * Fetch first element of list.
     *
     * @pre list is not empty
     * @post returns first value in list
     * 
     * @return A reference to first element of list.
     */
    public Object getFirst()
    {
        return head.value();
    }

    /**
     * Fetch last element of list.
     *
     * @pre list is not empty
     * @post returns last value in list
     * 
     * @return A reference to last element of list.
     */
    public Object getLast()
    {
        Node finger = head;
        while (finger != null &&
               finger.next() != null)
        {
            finger = finger.next();
        }
        return finger.value();
    }

    /**
     * Check to see if a value is in list.
     *
     * @pre value is not null
     * @post returns true iff value is found in list
     * 
     * @param value The value sought.
     * @return True if value is within list.
     */
    public boolean contains(Object value)
    {
        Node finger = head;
        while (finger != null &&
               !finger.value().equals(value))
        {
            finger = finger.next();
        }
        return finger != null;
    }

    /**
     * Remove a value from list.  At most one value will be removed.
     *
     * @pre value is not null
     * @post removes first element with matching value, if any
     * 
     * @param value The value to be removed.
     * @return The actual value removed.
     */
    public Object remove(Object value)
    {
        Node finger = head;
        Node previous = null;
        while (finger != null &&
               !finger.value().equals(value))
        {
            previous = finger;
            finger = finger.next();
        }
        // finger points to target value
        if (finger != null) {
            // we found element to remove
            if (previous == null) // it is first
            {
                head = finger.next();
            } else {              // it's not first
                previous.setNext(finger.next());
            }
            count--;
            return finger.value();
        }
        // didn't find it, return null
        return null;
    }

    /**
     * Determine number of elements in list.    
     *
     * @post returns number of elements in list
     * @return The number of elements in list.
     */
    public int size()
    {
        return count;
    }
    
    /**
     * Remove all values from list.
     *
     * @post removes all elements from list
     */
    public void clear()
    {
        head = null;
        count = 0;
    }

    /**
     * Get value at location i.
     *
     * @pre 0 <= i < size()
     * @post returns object found at that location
     *
     * @param i position of value to be retrieved.
     * @return value retrieved from location i (returns null if i invalid)
     */
    public Object get(int i)
    {
        if (i >= size()) return null;
        Node finger = head;
        // search for ith element or end of list
        while (i > 0)
        {
            finger = finger.next();
            i--;
        }
        return finger.value();
    }

    /**
     * Set value stored at location i to object o, returning old value.
     *
     * @pre 0 <= i < size()
     * @post sets ith entry of list to value o, returns old value
     * @param i location of entry to be changed.
     * @param o new value
     * @return former value of ith entry of list.
     */
    public Object set(int i, Object o)
    {
        if (i >= size()) return null;
        Node finger = head;
        // search for ith element or end of list
        while (i > 0)
        {
            finger = finger.next();
            i--;
        }
        // get old value, update new value
        Object result = finger.value();
        finger.setValue(o);
        return result;
    }

    /**
     * Insert value at location.
     *
     * @pre 0 <= i <= size()
     * @post adds ith entry of list to value o
     * @param i index of this new value
     * @param o value to be stored
     */
    public void add(int i, Object o)
    {
        if (i == size()) {
            addLast(o);
        } else if (i == 0) {
            addFirst(o);
        } else {
            Node previous = null;
            Node finger = head;
            // search for ith position, or end of list
            while (i > 0)
            {
                previous = finger;
                finger = finger.next();
                i--;
            }
            // create new value to insert in correct position
            Node current = new Node(o,finger);
            count++;
            // make previous value point to new value
            previous.setNext(current);
        }
    }

    /**
     * Remove and return value at location i.
     *
     * @pre 0 <= i < size()
     * @post removes and returns object found at that location
     *
     * @param i position of value to be retrieved.
     * @return value retrieved from location i (returns null if i invalid)
     */
    public Object remove(int i)
    {
        if (i == 0) return removeFirst();
        else if (i == size()-1) return removeLast();
        Node previous = null;
        Node finger = head;
        // search for value indexed, keep track of previous
        while (i > 0)
        {
            previous = finger;
            finger = finger.next();
            i--;
        }
        // in list, somewhere in middle
        previous.setNext(finger.next());
        count--;
        // finger's value is old value, return it
        return finger.value();
    }

    /**
     * Determine first location of a value in list.
     *
     * @pre value is not null
     * @post returns the (0-origin) index of value,
     *   or -1 if value is not found
     * 
     * @param value value sought
     * @return index (0 is first element) of value, or -1
     */
    public int indexOf(Object value)
    {
        int i = 0;
        Node finger = head;
        // search for value or end of list, counting along way
        while (finger != null && !finger.value().equals(value))
        {
            finger = finger.next();
            i++;
        }
        // finger points to value, i is index
        if (finger == null)
        {   // value not found, return indicator
            return -1;
        } else {
            // value found, return index
            return i;
        }
    }

    /**
     * Determine last location of a value in list.
     *
     * @pre value is not null
     * @post returns the (0-origin) index of value,
     *   or -1 if value is not found
     * 
     * @param value value sought.
     * @return index (0 is first element) of value, or -1
     */
    public int lastIndexOf(Object value)
    {
        int result = -1;        // assume not found, return -1
        int i = 0;
        Node finger = head;
        // search for last matching value, result is desired index
        while (finger != null)
        {
            // a match? keep track of location
            if (finger.value().equals(value)) result = i;
            finger = finger.next();
            i++;
        }
        // return last match
        return result;
    }

    /**
     * Returns an iterator traversing list from head to tail.
     *
     * @post returns enumeration allowing traversal of list
     * 
     * @return An iterator to traverse list.
     */
    public Iterator iterator()
    {
        return new SinglyLinkedListIterator(head);
    }
    /*
    // THIS CODE IS NOT AVAILABLE
    public int size()
    // post: returns number of elements in list
    {
        // number of elements we've seen in list
        int elementCount = 0;
        // reference to potential first element
        Node finger = head;
 
        while (finger != null) {
            // finger references a new element, count it
            elementCount++;
            // reference possible next element
            finger = finger.next();
        }
        return elementCount;
    }
    */

    /**
     * Construct a string representing list.
     *
     * @post returns a string representing list
     * 
     * @return A string representing list.
     */
    public String toString()
    {
        StringBuffer s = new StringBuffer();
        s.append("<SinglyLinkedList:");
        Enumeration li = (Enumeration)iterator();
        while (li.hasMoreElements())
        {
            s.append(" "+li.nextElement());
        }
        s.append(">");
        return s.toString();
    }

    public void splice(int index, List other){
        Iterator otherI = other.iterator();

        int i = index;
        while(otherI.hasNext()){
            add(i, otherI.next());
            i++;
        }

        other.clear();
    }

    public void reverse(){
        int i = size();

        while(i > 0){
            add(i - 1, removeFirst());
            i--;
        }
    }

    public void removeEveryOther(){
        for(int i = 0; i < size(); i++){
            remove(i);
        }
    }

    public static void main(String[] args){
        SinglyLinkedList list1 = new SinglyLinkedList();

        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        list1.add(5);

        list1.removeEveryOther();

        Iterator it = list1.iterator();

        while(it.hasNext()){
            System.out.println(it.next());
        }
    }
}

