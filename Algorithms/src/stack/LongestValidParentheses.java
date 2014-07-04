package stack;

import java.util.Stack;

public class LongestValidParentheses {
	public int longestValidParentheses(String s) {
		if (s == null) return 0;

		Stack<Integer> stack = new Stack<Integer>();
		int length = s.length();
		int start = -1;
		int maxLen = 0;
		char c;

		for (int i = 0; i < length; i++) {
			c = s.charAt(i);
			if (c == '(') {
				stack.push(i);
			} else {
				if (stack.isEmpty()) {
					start = i;    
				} else {
					stack.pop();
					if (stack.isEmpty()) maxLen = Math.max(maxLen, i-start);
					else maxLen = Math.max(maxLen, i-stack.peek());
				}
			}
		}

		return maxLen;
	}
}
