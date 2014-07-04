package stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {
	public boolean isValid(String s) {
		if (s == null) return false;

		Stack<Character> stack = new Stack<Character>();
		int size = s.length();
		char c;
		Character mc;
		Map<Character, Character> map = new HashMap<Character, Character>();
		map.put(')', '(');
		map.put(']', '[');
		map.put('}', '{');

		for (int i = 0; i < size; i++) {
			c = s.charAt(i);
			mc = map.get(c);
			if (mc != null) {
				if (stack.isEmpty()) return false;
				if (stack.pop() != mc) return false;
			} else {
				stack.push(c);
			}
		}

		if (stack.isEmpty()) return true;
		return false;
	}
}
