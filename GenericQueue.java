public class GenericQueue<T> extends GenericList<T> { // GenricQueue uses genric lists linked list to work and overrides add as it is abstract

    private Node<T> tail; // extra data member

    // with first in first out in mind
    @Override
    void add(T data) {
        Node<T> T = new Node<T>(data);
        if (getLength() == 0) {
            setHead(T);
            tail = getHead();
        } else {
            Node<T> tmp = getHead();
            while (tmp.getNext() != null) {
                tmp = tmp.getNext();
            }
            T.setPrev(tmp);
            tmp.setNext(T);
            tail = T;
        }
        setLength(getLength() + 1);
    }

    // removes the tail and points all the next and prev in the right direction.
    public T removeTail() {
        if (getLength() == 0) {
            return null;
        } else if (getLength() == 1) {
            T head_data = getHead().getData();
            setHead(null);
            setLength(0);
            return head_data;
        }
        Node<T> Temp = getHead();
        while (Temp.getNext() != tail) {
            Temp = Temp.getNext();
        }
        T node_data = Temp.getNext().getData();
        Temp.setNext(null);
        tail = Temp;
        setLength(getLength() - 1);

        return node_data;
    }

    // using the just created add function
    public void enqueue(T data) {
        add(data);
    }

    // using the inherited delete funciton from GenricList
    public T dequeue() {
        return delete();
    }
}
