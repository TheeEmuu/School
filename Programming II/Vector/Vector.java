// An implementation of extensible arrays.
// (c) 1998, 2001 duane a. bailey


public class Vector
{
    protected Object elementData[];     // the data
    protected int elementCount;         // number of elements in vector
    protected int capacityIncrement;    // the rate of growth for vector
    protected Object initialValue;      // new elements have this value

    public Vector()
    //post:  constructs a vector with capacity for 10 elements
    {
        this(10); // call one-parameter constructor
    }
    

    /**
     * Construct an empty vector capable of storing <code>initialCapacity</code>
     * values before the vector must be extended.
     *
     * @pre initialCapacity >= 0
     * @post constructs an empty vector with initialCapacity capacity
     * @param initialCapacity The size of vector before reallocation is necessary
     */
    public Vector(int initialCapacity)
    {
        Assert.pre(initialCapacity >= 0, "Initial capacity should not be negative.");
        elementData = new Object[initialCapacity];
        elementCount = 0;
        capacityIncrement = 0;
        initialValue = null;
    }
   
    
    /**
     * Fetch the element at a particular index.
     * The index of the first element is zero.
     *
     * @pre 0 <= index && index < size()
     * @post returns the element stored in location index
     * 
     * @param index The index of the value sought.
     * @return A reference to the value found in the vector.
     */
    public Object get(int index)
    {
        return elementData[index];
    }


    /**
     * Change the value stored at location index.
     *
     * @pre 0 <= index && index < size()
     * @post element value is changed to obj; old value is returned
     * 
     * @param obj The new value to be stored.
     * @param index The index of the new value.
     */
    public Object set(int index, Object obj)
    {
        Object previous = elementData[index];
        elementData[index] = obj;
        return previous;
    }
 
    /**
     * Add an element to the high end of the array, possibly expanding
     * vector.
     *
     * @post adds new element to end of possibly extended vector
     * 
     * @param obj The object to be added to the end of the vector.
     */
    public void add(Object obj)
    {
        ensureCapacity(elementCount+1);
        elementData[elementCount] = obj;
        elementCount++;
    }
    
    
    /**
     * Insert an element at a particular location.
     * Vector is grown as needed
     *
     * @pre 0 <= index <= size()
     * @post inserts new value in vector with desired index,
     *   moving elements from index to size()-1 to right
     * 
     * @param obj the value to be inserted.
     * @param index the location of the new value.
     */
    public void add(int index, Object obj)
    {
        int i;
        ensureCapacity(elementCount+1);
        // must copy from right to left to avoid destroying data
        for (i = elementCount; i > index; i--) {
            elementData[i] = elementData[i-1];
        }
        // assertion: i == index and element[index] is available
        elementData[index] = obj;
        elementCount++;
    }
    
    /**
     * Remove an element at a particular location.
     *
     * @pre 0 <= where && where < size()
     * @post indicated element is removed, size decreases by 1
     * 
     * @param where The location of the element to be removed.
     */
    public Object remove(int where)
    {
        Object result = get(where);
        elementCount--;
        while (where < elementCount) {
            elementData[where] = elementData[where+1];
            where++;
        }
        elementData[elementCount] = null; // free reference
        return result;
    }
    
    /**
     * Determine if the Vector contains no values.      
     *
     * @post returns true iff there are no elements in the vector
     * 
     * @return True iff the vector is empty.
     */
    public boolean isEmpty()
    {
        return size() == 0;
    }
    
    /**
     * Determine the number of elements in the vector.
     *
     * @post returns the size of the vector
     * 
     * @return The number of elements within the vector.
     */
    public int size()
    {
        return elementCount;
    }
    
    
    
    /**
     * Ensure that the vector is capable of holding at least
     * minCapacity values without expansion.
     *
     * @post the capacity of this vector is at least minCapacity
     * 
     * @param minCapacity The minimum size of array before expansion.
     */
    public void ensureCapacity(int minCapacity)
    {
        if (elementData.length < minCapacity) {
            int newLength = elementData.length; // initial guess
            if (capacityIncrement == 0) {
                // increment of 0 suggests doubling (default)
                if (newLength == 0) newLength = 1;
                while (newLength < minCapacity) {
                    newLength *= 2;
                }
            } else {
                // increment != 0 suggests incremental increase
                while (newLength < minCapacity)
                {
                    newLength += capacityIncrement;
                }
            }
            // assertion: newLength > elementData.length.
            Object newElementData[] = new Object[newLength];
            int i;
            // copy old data to array
            for (i = 0; i < elementCount; i++) {
                newElementData[i] = elementData[i];
            }
            elementData = newElementData;
            // garbage collector will (eventually) pick up old elementData
        }
        // assertion: capacity is at least minCapacity
    }
   
    
    
    /**
     * Determine the capacity of the vector.  The capacity is always
     * at least as large as its size.
     *
     * @post returns allocated size of the vector
     * 
     * @return The size of the array underlying the vector.
     */
    public int capacity()
    {
        return elementData.length;
    }

    /**
     * Construct a shallow copy of the vector.  The vector
     * store is copied, but the individual elements are shared
     * objects.
     *
     * @post returns a copy of the vector, using same objects
     * 
     * @return A copy of the original vector.
     */
    public Object clone()
    {
        Vector copy = null;
        try {
            copy = (Vector)super.clone();
            copy.elementData = (Object[])elementData.clone();
        } catch (java.lang.CloneNotSupportedException e) { Assert.fail("Vector cannot be cloned."); }
        return copy;
    }

    /**
     * Determine if a value appears in a vector.
     *
     * @post returns true iff Vector contains the value
     *       (could be faster, if orderedVector is used)
     * 
     * @param elem The value sought.
     * @return True iff the value appears in the vector.
     */
    public boolean contains(Object elem)
    {
        int i;
        for (i = 0; i < elementCount; i++) {
            if (elem.equals(elementData[i])) return true;
        }
        return false;
    }

    /**
     * Copy the contents of the vector into an array.
     * The array must be large enough to accept all the values in
     * the vector.
     *
     * @pre dest has at least size() elements
     * @post a copy of the vector is stored in the dest array
     * 
     * @param dest An array of size at least size(). 
     */
    public void copyInto(Object dest[])
    {
        int i;
        for (i = 0; i < elementCount; i++) {
            dest[i] = elementData[i];
        }
    }

    /**
     * Fetch the element at a particular index.
     * The index of the first element is zero.
     *
     * @pre 0 <= index && index < size()
     * @post returns the element stored in location index
     * 
     * @param index The index of the value sought.
     * @return A reference to the value found in the vector.
     */
    public Object elementAt(int index)
    {
        return get(index);
    }


    /**
     * Get access to the first element of the vector.
     *
     * @pre vector contains an element
     * @post returns first value in vector
     * 
     * @return Access to the first element of the vector.
     */
    public Object firstElement()
    {
        return get(0);
    }

    /**
     * Assuming the data is not in order, find the index of a
     * value, or return -1 if not found.
     *
     * @post returns index of element equal to object, or -1; starts at 0
     * 
     * @param elem The value sought in vector.
     * @return The index of the first occurrence of the value.
     */
    public int indexOf(Object elem)
    {
        return indexOf(elem,0);
    }

    /**
     * Assuming the data is not in order, find the index of a value
     * or return -1 if the value is not found.  Search starts at index.
     *
     * @post returns index of element equal to object, or -1; starts at index
     * 
     * @param elem The value sought.
     * @param index The first location considered.
     * @return The index of the first location, or -1 if not found.
     */
    public int indexOf(Object elem, int index)
    {
        int i;
        for (i = index; i < elementCount; i++)
        {
            if (elem.equals(elementData[i])) return i;
        }
        return -1;
    }

    /**
     * Insert an element at a particular location.
     * Vector is grown as needed
     *
     * @pre 0 <= index <= size()
     * @post inserts new value in vector with desired index,
     *   moving elements from index to size()-1 to right
     * 
     * @param obj The value to be inserted.
     * @param index The location of the new value.
     *
     */
    public void insertElementAt(Object obj, int index)
    {
        add(index,obj);
    }


    /**
     * Fetch a reference to the last value in the vector.
     *
     * @pre vector is not empty
     * @post returns last element of the vector
     * 
     * @return A reference to the last value.
     */
    public Object lastElement()
    {
        return get(elementCount-1);
    }

    /**
     * Search for the last occurrence of a value within the
     * vector.  If none is found, return -1.
     *
     * @post returns index of last occurrence of object in the vector, or -1
     * 
     * @param obj The value sought.
     * @return The index of the last occurrence in the vector.
     */
    public int lastIndexOf(Object obj)
    {
        return lastIndexOf(obj,elementCount-1);
    }

    /**
     * Find the index of the last occurrence of the value in the vector before
     * the indexth position.
     *
     * @pre index >= 0
     * @post returns the index of last occurrence of object at or before
     *       index
     * 
     * @param obj The value sought.
     * @param index The last acceptable index.
     * @return The index of the last occurrence of the value, or -1 if none.
     */
    public int lastIndexOf(Object obj, int index)
    {
        int i;
        for (i = index; i >= 0; i--) {
            if (obj.equals(elementData[i])) return i;
        }
        return -1;
    }

    /**
     * Remove all the values of the vector.
     *
     * @post vector is empty
     */
    public void clear()
    {
        setSize(0);
    }

    /**
     * Remove all the elements of the vector.
     * Kept for compatibility with java.util.Vector.
     *
     * @post vector is empty
     *
     * @see #clear
     */
    public void removeAllElements()
    {
        setSize(0);
    }

  

    /**
     * Remove an element at a particular location.
     *
     * @pre 0 <= where && where < size()
     * @post indicated element is removed, size decreases by 1
     * 
     * @param where The location of the element to be removed.
     */
    public void removeElementAt(int where)
    {
        remove(where);
    }


    /**
     * Change the value stored at location index.
     *
     * @pre 0 <= index && index < size()
     * @post element value is changed to obj
     * 
     * @param obj The new value to be stored.
     * @param index The index of the new value.
     */
    public void setElementAt(Object obj, int index)
    {
        set(index,obj);
    }



    /**
     * Explicitly set the size of the array.
     * Any new elements are initialized to the default value.
     *
     * @pre newSize >= 0
     * @post vector is resized, any new elements are initialized
     * 
     * @param newSize The ultimate size of the vector.
     */
    public void setSize(int newSize)
    {
        int i;
        if (newSize < elementCount) {
            for (i = newSize; i < elementCount; i++) elementData[i] = null;
        } else {
            for (i = elementCount; i < newSize; i++)
                elementData[i] = initialValue;
        }
        elementCount = newSize;
    }


    /**
     * Determine a string representation for the vector.
     *
     * @post returns a string representation of vector
     * 
     * @return A string representation for the vector.
     */
    public String toString()
    {
        StringBuffer sb = new StringBuffer();
        int i;

        sb.append("<Vector:");
        for (i = 0; i < size(); i++)
        {
            sb.append(" "+get(i));
        }
        sb.append(">");
        return sb.toString();
    }

}

