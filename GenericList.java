// Miran Member
// This Project is about implementing iterators for custom data structure.

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

abstract class GenericList<T> implements Iterable<T> { // Generic class which will later be used for stack and queue.

    class Node<T> { // Node for linked list
        private T data;
        private Node<T> next;
        private Node<T> prev;

        Node(T data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }

        //getters and setters for Node in case you have to use it outside of the parent class.
        public void setData(T data) {
            this.data = data;
        }

        public T getData() {
            return data;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setPrev(Node<T> prev) {
            this.prev = prev;
        }

        public Node<T> getPrev() {
            return prev;
        }
    }

    private Node<T> Head;
    private int length;

    // Default consructor which has zero parameters because if you want to add stuff to the linked list you have to use the add function.
    GenericList() {
        Head = null;
        length = 0;
    }

    // prints the contents of the list
    public void print() {
        if (length == 0) {
            System.out.println("Empty List");
        } else {
            Node<T> tmp = Head;
            while (tmp != null) {
                System.out.println(tmp.data);
                tmp = tmp.next;
            }
        }
    }

    //abstract add mathod which later will be added in the stack and queue implementation.
    abstract void add(T data);

    // deletes the first elemt and moves the dead to the next
    public T delete() {
        if (length == 0) {
            System.out.println("Empty List");
            return null;
        } else {
            T t = Head.data;
            Head = Head.next;
            Head.setPrev(null);
            length--;
            return t;
        }
    }

    // creates and array and stores all the values of the linked list in the array and returns it
    public ArrayList<T> dumpList() {
        ArrayList<T> List = new ArrayList<T>(); // might not work
        Node<T> tmp = Head;
        while (tmp != null) {
            List.add(tmp.data);
            tmp = tmp.next;
        }
        Head = null;
        length = 0;
        return List;
    }

    // get the value at the index.
    public T get(int index) {
        int counter = 0;
        Node<T> tmp = Head;
        while (tmp != null) {
            if (counter == index) {
                return tmp.data;
            }
            tmp = tmp.next;
            counter++;
        }
        return null;
    }

    // set the value at the index
    public T set(int index, T element) {
        int counter = 0;
        Node<T> tmp = Head;
        while (tmp != null) {
            if (counter == index) {
                T t = tmp.data;
                tmp.data = element;
                return t;
            }
            tmp = tmp.next;
            counter++;
        }
        return null;
    }

    // getters and setters for the private data members of the class
    public int getLength() {
        return length;
    }

    public void setLength(int i) {
        this.length = i;
    }

    public Node<T> getHead() {
        return Head;
    }

    public void setHead(Node<T> head) {
        Head = head;
    }

    // default uses GLLIterator but can be changed to use any user prefers.
    @Override
    public Iterator<T> iterator() {
        return new GLLIterator<T>(Head);
    }

    // uses GLListIterator to print array from certain index.
    public ListIterator<T> listIterator(int index) {
        GLListIterator Iter = new GLListIterator(Head);

        while(index > 0) {
            Iter.next();
            index--;
        }
        return Iter;
    }

    // returns Iterator in reverse order
    public Iterator<T> descendingIterator( ) {
        Node<T> tmp = Head;
        while (tmp.next != null) {
            tmp = tmp.next;
        }
        ReverseGLLIterator Iter = new ReverseGLLIterator(tmp);
        return Iter;
    }
}