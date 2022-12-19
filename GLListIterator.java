import java.util.ListIterator;

public class GLListIterator<E> implements ListIterator<E> {
    GenericList<E>.Node<E> curr;
    static int x = 0;

    public GLListIterator (GenericList<E>.Node<E> x) {
        this.curr = x;
    }

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

    @Override
    public boolean hasPrevious() {
        return curr != null;
    }

    @Override
    public E previous() {
        E data = curr.getData();
        curr = curr.getPrev();
        return data;
    }
    @Override
    public int nextIndex() {
        x++;
        return x;
    }

    @Override
    public int previousIndex() {
        return x - 1;
    }

    public void remove() {

    }

    public void set(E e) {

    }

    public void add(E e) {

    }
}
