import java.util.Iterator;
/**
 * Linked list implementation of the MyList interface.
 * Giselle Muriel
 */
public class MyLinkedList<E> implements MyList<E>
{
    private Node head, tail;
    private int size;

    /**
     * Constructs an empty list.
     */
    public MyLinkedList()
    {
        head = tail = null;
        size = 0;
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

        Node p = head;
        for (int i = 0; i < index; i++, p = p.next);
        E oldElement = p.element;
        p.element = element;

        return oldElement;
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

        Node p = head;
        for (int i = 0; i < index; i++, p = p.next);

        return p.element;
    }

    /**
     * Appends the specified element to the end of this list.
     * @param element element to be appended to this list
     * @return true
     */
    public boolean add(E element)
    {
        Node n = new Node(element);

        if (head == null)
        {
            head = tail = n;
        }
        else
        {
            tail.next = n;
            tail = n;
        }

        size++;

        return true;
    }

    /**
     * Removes all of the elements from this list.
     */
    public void clear()
    {
        head = tail = null;
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
        Node p = head;
        StringBuilder result = new StringBuilder();

        //appending [ at the beginning of the string
        result.append("[");

        //as long as there is a value in the list
        while(p != null)
        {
            //append the element into the String
            result.append(p.element);

            //if there is a value following it
            if(p.next != null)
            {
                //add a comma
                result.append(", ");
            }

            //continuing through the loop, declaring the next value as the new head
            p = p.next;
        }

        //ending it with the last bracket
        result.append("]");

        //returning the String we created with StringBuilder
        return result.toString();
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
        //if index is negative or greater than the list size
        if (index < 0 || index > size)
        {
            //error
            throw new IndexOutOfBoundsException("Index: " + index + ", list size: " + size);
        }

        //declaring new specified element
        Node n = new Node(element);
        Node p = head;

        //if element is inserted in the first spot
        if(index == 0)
        {
            //set the current head to the spot next to the element...
            n.next = head;
            //...since the element is now the head
            head = n;

            //if the size of the list is 0
            if(size == 0)
            {
                //the element is set to the tail (end)
                tail = n;
            }
        }
        else if (index == size)
        {
            //if element is placed at the end of the list
            //the spot after the tail (end) is now set to that specified element (n)
            tail.next = n;
            //the last value is now the specified element (n)
            tail = n;
        }
        else //any other case
        {
            //going from beginning of list to second to last
            for (int i = 0; i < index - 1; i++)
            {
                //shifting values
                p = p.next;
            }

            //the spot after the specified element (n) is set to the spot following the index we're in
            n.next = p.next;
            //this index is then set to the specified element (n)
            p.next = n;
        }

        //increasing size of the list
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
        //if index is negative or greater than or equal to the size of the list
        if (index < 0 || index >= size)
        {
            //error
            throw new IndexOutOfBoundsException("Index: " + index + ", list size: " + size);
        }

        //creating Object to hold the removed element
        E oldElement;
        Node p = head;

        //if size of the list is 0
        if(size == 0)
        {
            //nothing to return
            return null;
        }

        //if index chosen is 0
        if(index == 0)
        {
            //oldElement value holds that specified value
            oldElement = p.element;
            //the new head is given to the following element
            head = p.next;

            //if the size is 1
            if(size == 1)
            {
                //there is no tail
                tail = null;
            }
        }
        else //any other case
        {
            //going from beginning of list to second to last
            for(int i = 0; i < index - 1; i++)
            {
                //shifting elements
                p = p.next;
            }

            //oldElement is set to the element in the index following p
            oldElement = p.next.element;
            //the element in the index following p is moved over to the next spot.
            p.next = p.next.next;

            //if the index chosen is the second to last one
            if(index == size - 1)
            {
                //tail is now that specific spot
                tail = p;
            }
        }

        //decreasing size of the list
        size--;

        //returning our removed element
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
        Node p = head;
        int index = 0;

        //while the list isn't empty
        while(p != null)
        {
            /*if the specified element is equal to element we have in the list or
            the element is null and the element in the list is also null
             */
            if(element.equals(p.element) || (element == null && p.element == null))
            {
                //return the index of where you found it
                return index;
            }

            //continuing through the loop, declaring the next value as the new head
            p = p.next;
            //increasing value of index
            index++;
        }

        //if not found, return -1
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
        Node p = head;
        //keeps count
        int count = 0;

        //going through list
        for(int i = 0; i < size; i++)
        {
            /*if the specified element is null and the element in the list is also null or
            specified element isn't null and equals the element in the list
             */
            if((element == null && p.element == null) ||
                    (element != null && element.equals(p.element)))
            {
                //increase the count
                count++;
            }

            p = p.next;
        }

        //if specified element isn't found
        if(count == 0)
        {
            //return empty array
            return new int[0];
        }

        //creating new array holding indexes for each instance of the specified element
        int[] indexes = new int[count];
        p = head;
        int index = 0;

        //going through list again
        for(int i = 0; i < size; i++)
        {
            if ((element == null && p.element == null) ||
                    (element != null && element.equals(p.element)))
            {
                //going forward in our array and adding in the indexes
                indexes[index++] = i;
            }

            p = p.next;
        }

        //return our array
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
        Node p = head;
        Node q = null;
        Node next;

        //while the list has values
        while(p != null)
        {
            //Stores the next node in the list to 'next' variable
            next = p.next;
            //reverses by making next pointer of current node point to previous node (q)
            p.next = q;
            //sets q to current node p
            q = p;
            //advances p pointer to next node
            p = next;
        }

        //then sets the last element to the first element
        tail = head;
        //sets first element to last point on the list
        head = q;
    }

    public Iterator<E> iterator()
    {
        return new ListItr();
    }
    private class ListItr implements Iterator<E>
    {
        private Node current;
        ListItr()
        {
            current = head;
        }

        @Override
        public boolean hasNext()
        {
            return current != null;
        }

        @Override
        public E next()
        {
            E element = current.element;
            current = current.next;

            return element;
        }

        @Override
        public void remove()
        {
            throw new UnsupportedOperationException();
        }
    }
    private class Node
    {
        Node next;
        E element;

        public Node(E element)
        {
            this.element = element;
        }
    }
}
