package stack;

import java.util.Stack;

public class MaximalRectangle {
    public int maxRectHist(int[] h) {
        Stack<Integer> s = new Stack<Integer>();
        
        int max = 0, toph = 0, width = 0;
        for (int i = 0; i < h.length; i++) {
            while (!s.isEmpty() && h[i] < h[s.peek()]) { // h!  while !
                toph = h[s.pop()];
                if (s.isEmpty()) width = i;
                else width = i - s.peek() - 1;
                max = Math.max(max, toph * width);
            }
            s.push(i);
        }

        while (!s.isEmpty()) {
            toph = h[s.pop()];
            if (s.isEmpty()) width = h.length;
            else width = h.length - s.peek() - 1;
            max = Math.max(max, toph * width); 
        }       
        
        return max;
    }
    
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        
        int m = matrix.length, n = matrix[0].length, max = 0;
        int[] h = new int[n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                h[j] = (matrix[i][j] =='0' ? 0 : h[j] + 1); // !
            }
            max = Math.max(max, maxRectHist(h));
        }
        
        return max;    
    }
    
    public static void main(String[] args) {
    	MaximalRectangle x = new MaximalRectangle();
    	char[][] matrix = {{'0', '1'}, {'1', '0'}};
    	
    	assert(1 == x.maximalRectangle(matrix));
    }
}
