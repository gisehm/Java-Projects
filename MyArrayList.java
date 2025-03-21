import java.util.Iterator;

/**
 * Resizable-array implementation of the MyList interface.
 * Muriel
 */
public class MyArrayList<E> implements MyList<E>
{
    /**
     * Default initial capacity.
     */
    private static final int DEFAULT_CAPACITY = 10;

    /**
     * The size of the ArrayList (the number of elements it contains).
     */
    private int size;

    /**
     * The array buffer into which the elements of the ArrayList are stored.
     * The capacity of the ArrayList is the length of this array buffer.
     */
    Object[] elementData; // non-private to simplify nested class access

    /**
     * Constructs an empty list with the specified initial capacity.
     * @param initialCapacity the initial capacity of the list
     * @throws IllegalArgumentException if the specified initial capacity
     * is negative
     */
    public MyArrayList(int initialCapacity)
    {
        if (initialCapacity < 0)
        {
            throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
        }

        this.elementData = new Object[initialCapacity];
    }

    /**
     * Constructs an empty list with an initial capacity of ten.
     */
    public MyArrayList()
    {
        this.elementData = new Object[DEFAULT_CAPACITY];
    }

    /**
     * Returns the number of elements in this list.
     * @return the number of elements in this list
     */
    public int size()
    {
        return size;
    }

    /**
     * Returns true if this list contains no elements.
     * @return true if this list contains no elements
     */
    public boolean isEmpty()
    {
        return size == 0;
    }

    /**
     * Appends the specified element to the end of this list.
     * @param element element to be appended to this list
     * @return true
     */
    public boolean add(E element)
    {
        if (size + 1 > elementData.length)
        {
            Object[] newData = new Object[size * 2 + 1];

            for (int i = 0; i < size; i++)
            {
                newData[i] = elementData[i];
            }

            elementData = newData;
        }

        elementData[size++] = element;
        return true;
    }

    /**
     * Returns the element at the specified position in this list.
     * @param index index of the element to return
     * @return the element at the specified position in this list
     * @throws IndexOutOfBoundsException - if the index is out of range
     * (index < 0 || index >= size())
     */
    public E get(int index)
    {
        if (index < 0 || index >= size)
        {
            throw new IndexOutOfBoundsException("Index: " + index + ", list size: " + size);
        }

        return (E)elementData[index];
    }

    /**
     * Replaces the element at the specified position in this list with the
     * specified element.
     * @param index index of the element to return
     * @param element element to be stored at the specified position
     * @return the element at the specified position in this list
     * @throws IndexOutOfBoundsException - if the index is out of range
     * (index < 0 || index >= size())
     */
    public E set(int index, E element)
    {
        if (index < 0 || index >= size)
        {
            throw new IndexOutOfBoundsException("Index: " + index + ", list size: " + size);
        }

        E oldValue = (E)elementData[index];
        elementData[index] = element;

        return oldValue;
    }

    /**
     * Removes all of the elements from this list.
     */
    public void clear()
    {
    // clear to let GC do its work
        for (int i = 0; i < size; i++)
        {
            elementData[i] = null;
        }

        size = 0;
    }

    /**
     * Returns a string representation of the list. The string will begin with
     * a '[' and end with a ']'. Inside the square brackets will be a comma-
     * separated list of values, such as [Brian, Susan, Jamie].
     * @return a string representation of the list
     */
    @Override
    public String toString()
    {
        //If there are no elements in the list
        if(size == 0)
        {
            return "[]";
        }

        //appends [ at the beginning of the string
        StringBuilder sb = new StringBuilder("[");

        /*going through the list except for the second to last element because the
        bracket would go there, not a comma
        */
        for (int i = 0; i < size - 1; i++)
        {
            //adding comma after each element
            sb.append(elementData[i]).append(", ");
        }

        //ending off with the end bracket
        sb.append(elementData[size - 1]).append("]");

        //returning the String we created using StringBuilder
        return sb.toString();
    }

    /**
     * Inserts the specified element at the specified position in this list.
     * Shifts the element currently at that position (if any) and any subsequent
     * elements to the right (adds one to their indices).
     * @param index index at which the specified element is to be inserted
     * @param element element to be inserted
     * @throws IndexOutOfBoundsException if the index is out of range
     *         (index < 0 || index > size())
     * The exception message must be:
     * "Index: " + index + ", list size: " + size
     */
    public void add(int index, E element)
    {
        //if the index is negative or greater than the list size
        if(index < 0 || index > size())
        {
            //error
            throw new IndexOutOfBoundsException("Index: " + index + ", list size: " + size);
        }

        //if larger list size is greater than our actual list size...
        if (size + 1 > elementData.length)
        {
            //create larger list
            Object[] newData = new Object[size * 2 + 1];

            //basically copying the elementData list to the new list except for the new index where we'll add the element
            for (int i = 0; i < index; i++)
            {
                newData[i] = elementData[i];
            }

            //adding the element in newData's empty index
            newData[index] = element;

            //copying elements from old array into new array
            for(int i = index; i < size; i++)
            {
                newData[i + 1] = elementData[i];
            }

            //setting our original list to the new list
            elementData = newData;
        }

        for(int i = size; i > index; i--)
        {
            //shifting elements to the left
            elementData[i] = elementData[i - 1];
        }

        //inserting the element into the list
        elementData[index] = element;
        //increase list size
        size++;
    }

    /**
     * Removes the element at the specified position in this list.
     * @param index the index of the element to be removed
     * @return the element that was removed from the list
     * @throws IndexOutOfBoundsException if the index is out of range
     *         (index < 0 || index >= size())
     * The exception message must be:
     * "Index: " + index + ", list size: " + size
     */
    public E remove(int index)
    {
        //if index is negative or greater than or equal to the list size
        if(index < 0 || index >= size())
        {
            //error
            throw new IndexOutOfBoundsException("Index: " + index + ", list size: " + size);
        }

        //specifying variable for the oldElement we're removing
        E oldElement = (E)elementData[index];

        //going through the list
        for (int i = index; i < size - 1; i++)
        {
            //shifting elements
            elementData[i] = elementData[i + 1];
        }

        //setting last element to null to clear the empty index
        elementData[size - 1] = null;

        //decreasing list size
        size--;

        //returns removed element
        return oldElement;
    }

    /**
     * Returns the index of the first occurrence of the specified element in
     * this list, or -1 if this list does not contain the element. More
     * formally, returns the lowest index i such that Objects.equals(o, get(i)),
     * or -1 if there is no such index.
     * @param element element to search for
     * @return the index of the first occurrence of the specified element in
     * this list, or -1 if this list does not contain the element
     */
    public int indexOf(E element)
    {
        //goes through the list
        for(int i = 0; i < size; i++)
        {
            //if number in the list is equal to the specified element
            if(elementData[i] == element)
            {
                //return the index
                return i;
            }
        }

        //if not, return -1
        return -1;
    }

    /**
     * Returns an array of indexes of each occurrence of the specified element
     * in this list, in ascending order. If the specified element is not found,
     * a non-null empty array (not null) is returned.
     * @param element element to search for
     * @return an array of each occurrence of the specified element in this
     * list
     */
    public int[] indexesOf(E element)
    {
        //empty variable to keep count
        int count = 0;

        //going through list
        for(int i = 0; i < size; i++)
        {
            //if the number in the list is equal to the specified element
            if(elementData[i] == element)
            {
                //increase the count
                count++;
            }
        }

        //creating new array holding the number of instances
        int[] indexes = new int[count];
        int index = 0;

        //going through list
        for(int i = 0; i < size; i++)
        {
            //if the number in the list is equal to the specified element
            if(elementData[i] == element)
            {
                //goes forward in array and adds the index
                indexes[index++] = i;
            }
        }

        //returns our array
        return indexes;
    }

    /**
     * Reverse the data in the list.
     * For MyArrayList, the data inside the underlying array is moved. For
     * MyLinkedList, the tail must become the head, and all the pointers are
     * reversed. Both implementations must run in Theta(n) time and Theta(1)
     * space.
     */
    public void reverse()
    {
        Object k;

        //going through lower half of list
        for(int i = 0; i < (size / 2); i++)
        {
            //Object is equal to the element in the list
            k = elementData[i];
            //this element is set to the opposite spot on the list
            //ex, if i is 2 and size is 7, element is placed in index 4
            elementData[i] = elementData[size - i - 1];
            //element is then switched to the opposite spot
            elementData[size - i - 1] = k;
        }
    }

    /**
     * Returns an iterator over the elements in this list (in proper
     * sequence).
     *
     * The returned list iterator is fail-fast -- modification of the elements
     * is not permitted during iteration.
     */
    public Iterator<E> iterator()
    {
        return new ListItr();
    }

    private class ListItr implements Iterator<E>
    {
        private int current;
        ListItr()
        {
            current = 0;
        }

        @Override
        public boolean hasNext()
        {
            return current < size;
        }

        @Override
        public E next()
        {
            return (E)elementData[current++];
        }

        @Override
        public void remove()
        {
            throw new UnsupportedOperationException();
        }
    }
}
