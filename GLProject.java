import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class GLProject {


	public static void main(String[] args) {
		GenericQueue<Integer> jim = new GenericQueue<Integer>();

		jim.enqueue(12);
		jim.enqueue(34);
		jim.enqueue(18);
		jim.enqueue(19);
		jim.enqueue(12);
		jim.enqueue(16);
		jim.enqueue(16);
		jim.enqueue(19);
		jim.enqueue(18);

		for (Iterator it = jim.descendingIterator(); it.hasNext();) {
			System.out.println(it.next());
		}

	}
}
