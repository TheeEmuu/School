// An implementation of extensible arrays.
// (c) 1998, 2001 duane a. bailey


public class Vector<E>
{
    protected Object elementData[];     // the data
    protected int elementCount;         // number of elements in vector
    protected int capacityIncrement;    // the rate of growth for vector
    protected E initialValue;      // new elements have this value

    public Vector()
    //post:  constructs a vector with capacity for 10 elements
    {
        this(10, 0, null); // call one-parameter constructor
    }
    

    public Vector(int initialCapacity, int CapacityIncr, E initValue)
    {
        elementData = new Object[initialCapacity];
        elementCount = 0;
        capacityIncrement = CapacityIncr;
        initialValue = initValue;
    }
   
    
    public E get(int index)
    {
        return (E)elementData[index];
    }



    public E set(int index, E obj)
    {
        E previous = (E)elementData[index];
        elementData[index] = obj;
        return previous;
    }
 

    public void add(E obj)
    {
        ensureCapacity(elementCount+1);
        elementData[elementCount] = obj;
        elementCount++;
    }
    
    
    public void add(int index, E obj)
    {
        int i;
        ensureCapacity(elementCount+1);
        for (i = elementCount; i > index; i--) {
            elementData[i] = elementData[i-1];
        }
        elementData[index] = obj;
        elementCount++;
    }
    

    public E remove(int where)
    {
        E result = get(where);
        elementCount--;
        while (where < elementCount) {
            elementData[where] = elementData[where+1];
            where++;
        }
        elementData[elementCount] = initialValue; // free reference
        return result;
    }
    
    public boolean isEmpty()
    {
        return size() == 0;
    }
    

    public int size()
    {
        return elementCount;
    }
    
    
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
   
    
    public int capacity()
    {
        return elementData.length;
    }


    /*
     * This method assumes that class E imlements an equals method
     */
    public boolean contains(E elem)
    {
        int i;
        for (i = 0; i < elementCount; i++) {
            if (elem.equals((E)elementData[i])) return true;
        }
        return false;
    }



    public E elementAt(int index)
    {
        return get(index);
    }


    public E firstElement()
    {
        return get(0);
    }


    public int indexOf(E elem)
    {
        return indexOf(elem,0);
    }


    public int indexOf(E elem, int index)
    {
        int i;
        for (i = index; i < elementCount; i++)
        {
            if (elem.equals((E)elementData[i])) return i;
        }
        return -1;
    }


    public void insertElementAt(E obj, int index)
    {
        add(index,obj);
    }



    public E lastElement()
    {
        return get(elementCount-1);
    }


    public int lastIndexOf(E obj)
    {
        return lastIndexOf(obj,elementCount-1);
    }


    public int lastIndexOf(E obj, int index)
    {
        int i;
        for (i = index; i >= 0; i--) {
            if (obj.equals((E)elementData[i])) return i;
        }
        return -1;
    }


    public void clear()
    {
        setSize(0);
    }


    public void removeAllElements()
    {
        setSize(0);
    }

  
    public void removeElementAt(int where)
    {
        remove(where);
    }



    public void setElementAt(E obj, int index)
    {
        set(index,obj);
    }



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

