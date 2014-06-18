package lists;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ListIterator implements Iterator<ListNode> {
	ListNode curr;
	
	public ListIterator (ListNode head) {
		curr = head;
	}

	@Override
	public boolean hasNext() {
		return curr.next != null;
	}

	@Override
	public ListNode next() {
		if (!hasNext()) 
			throw new NoSuchElementException();
		return curr.next;
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}
}
