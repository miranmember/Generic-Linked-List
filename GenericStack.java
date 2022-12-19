public class GenericStack<T> extends GenericList<T> {
    private Node<T> tail;

    // Using the last in first out logic to add to the linked list
    @Override
    public void add(T data) {
        Node<T> T = new Node<T>(data);
        if (getLength() == 0) {
            setHead(T);
            tail = getHead();
        } else {
            Node<T> tmp = new Node<T>(data);
            tmp.setNext(getHead());
            getHead().setPrev(tmp);
            setHead(tmp);
        }
        setLength(getLength() + 1);
    }

    // remove tail
    public T removeTail() {
        if (getLength() == 0) {
            return null;
        } else if (getLength() == 1) {
            T t = getHead().getData();
            setHead(null);
            setLength(0);
            return t;
        }
        Node<T> Temp = getHead();
        while (Temp.getNext() != tail) {
            Temp = Temp.getNext();
        }
        T element = Temp.getNext().getData();
        Temp.setNext(null);
        tail = Temp;
        setLength(getLength() - 1);
        return element;
    }

    // using the add fucntion
    public void push(T data) { add(data); }
    // using the inherited delete.
    public T pop() { return delete(); }
}