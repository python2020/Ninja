package stack;

import java.util.Stack;

public class LargestRectangleInHistogram {
	public int largestRectangleArea(int[] height) {
		Stack<Integer> stack = new Stack<Integer>();

		int max = 0, h = 0, toph = 0;
		for (int i = 0; i < height.length; i++) {
			h = height[i];
			while (!stack.isEmpty() && h < height[stack.peek()]) { 
				toph = height[stack.pop()];
				if (stack.isEmpty()) 
					max = Math.max(max, toph * i);       
				else 
					max = Math.max(max, toph * (i - stack.peek() - 1));    
			}
			stack.push(i); 
		}

		while (!stack.isEmpty()) {
			h = height[stack.pop()];
			if (stack.isEmpty()) 
				max = Math.max(max, h * height.length);       
			else 
				max = Math.max(max, h * (height.length - stack.peek() - 1));  
		}     

		return max;
	}
}
