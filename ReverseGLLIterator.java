import java.util.Iterator;

public class ReverseGLLIterator<E> implements Iterator<E> {
    GenericList<E>.Node<E> curr;

    public ReverseGLLIterator (GenericList<E>.Node<E> x) {
        this.curr = x;
    }

    @Override
    public boolean hasNext() {
        return curr != null;
    }

    @Override
    public E next() {
        E data = curr.getData();
        curr = curr.getPrev();
        return data;
    }
}
