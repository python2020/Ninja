package stack;

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class StackWithMax<T extends Comparable<T>> {
	private LinkedList<T> first = new LinkedList<T>();
	private LinkedList<T> second = new LinkedList<T>();


	public void push(T e) {
		if (isEmpty() || e.compareTo(second.peekLast()) >= 0) second.addLast(e);
		first.addLast(e);		
	}


	public T pop() {
		if (isEmpty()) throw new NoSuchElementException("empty stack");

		T last = first.peekLast();
		if (last.compareTo(second.peekLast()) == 0) second.removeLast();
		first.removeLast();

		return last;
	}

	public T peek() {
		if (isEmpty()) return null;

		return first.getLast();
	}

	public boolean isEmpty() {
		return first.isEmpty();
	}

	public T max() {
		if (isEmpty()) return null;

		return second.getLast();
	}


	public static void main(String[] args) {
		StackWithMax<Integer> s = new StackWithMax<Integer>();
		try {
			s.push(1);
			assert (s.peek() == 1);
			s.pop();
			s.pop();
			s.pop();
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
		}

		s.push(1);
		s.push(10);
		assert (s.max() == 10);
		s.push(2);
		assert (s.max() == 10);
		assert (s.max() != s.pop());
		assert (s.max() == s.pop());
		assert (s.max() == 1);
		s.push(3);
		s.push(3);
		assert (s.max() == 3);
		s.pop();
		assert (s.max() == 3);
		s.pop();
		assert (s.max() == 1);
		s.pop();
	}
}
