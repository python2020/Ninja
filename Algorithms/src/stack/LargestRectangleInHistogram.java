package stack;

import java.util.Stack;

public class LargestRectangleInHistogram {
	public int largestRectangleArea(int[] height) {
		Stack<Integer> stack = new Stack<Integer>();

		int max = 0, toph = 0, width = 0;
		for (int i = 0; i < height.length; i++) {
			while (!stack.isEmpty() && height[i] < height[stack.peek()]) { // while! h!
				toph = height[stack.pop()];
			    if (stack.isEmpty()) width = i;
                else width = i - stack.peek() - 1;
                max = Math.max(max, toph * width);
			}
			stack.push(i); 
		}

		while (!stack.isEmpty()) {
			toph = height[stack.pop()];
			if (stack.isEmpty()) width = height.length;
            else width = height.length - stack.peek() - 1;
            max = Math.max(max, toph * width); 
		}     

		return max;
	}
}
