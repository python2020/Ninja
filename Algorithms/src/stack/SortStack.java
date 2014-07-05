package stack;

import java.util.Random;
import java.util.Stack;

public class SortStack<T extends Comparable<T>> {
	public void sort(Stack<T> stack) {
		if (stack.isEmpty()) return; // !
		
		T top = stack.pop();
		sort(stack);
		insert(stack, top);
	}
	
	// ascending
	public void insert(Stack<T> stack, T elem) {
		if (stack.isEmpty() || elem.compareTo(stack.peek()) < 0) {
			stack.push(elem);
		} else {
			T top = stack.pop();
			insert(stack, elem);
			stack.push(top);
		}
	}
	
	
	public static void main(String[] args) {
		SortStack<Integer> ss = new SortStack<Integer>();
		Stack<Integer> s = new Stack<Integer>();
		Random rand = new Random();
		int N = 30;
		int total = rand.nextInt(N);
		for (int i = 0; i < total; i++) s.push(rand.nextInt(N));
		ss.sort(s);
		
		while (!s.isEmpty()) System.out.println(s.pop());
	}
}
