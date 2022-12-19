import java.util.Iterator;
public class GLLIterator<E> implements Iterator<E> {
    GenericList<E>.Node<E> curr;
    // default constructor

    public GLLIterator (GenericList<E>.Node<E> x) {
        this.curr = x;
    }

    //
    @Override
    public boolean hasNext() {
        return curr != null;
    }

    @Override
    public E next() {
        E data = curr.getData();
        curr = curr.getNext();
        return data;
    }
}
