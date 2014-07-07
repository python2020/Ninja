package arrays;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
	public int[][] generateMatrix(int n) {
		int k = 1, l = 0, t = 0, r = n-1, b = n-1;
		int[][] matrix = new int[n][n];

		int m = n * n;
		while (k <= m) {
			for (int i = l; i <= r; i++) matrix[t][i] = k++;
			t++;
			for (int i = t; i <= b; i++) matrix[i][r] = k++;
			r--;
			for (int i = r; i >= l; i--) matrix[b][i] = k++;
			b--;
			for (int i = b; i >= t; i--) matrix[i][l] = k++;
			l++;
		}

		return matrix;
	}
	
    public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (matrix == null || matrix.length == 0) return res;
        
        int l = 0, r = matrix[0].length - 1, t = 0, b = matrix.length - 1;
        
        while (true) {
            for (int i = l; i <= r; i++) res.add(matrix[t][i]);
            if (++t > b) break; // !
            
            for (int i = t; i <= b; i++) res.add(matrix[i][r]);
            if (--r < l) break;
            
            for (int i = r; i >= l; i--) res.add(matrix[b][i]);
            if (--b < t) break;
            
            for (int i = b; i >= t; i--) res.add(matrix[i][l]);
            if (++l > r) break;
        }
        
        return res;
    }

	public void printMatrix(int[][] matrix) {
		int m = matrix.length, n = matrix[0].length;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		SpiralMatrix x = new SpiralMatrix();
		x.printMatrix(x.generateMatrix(3));
	}
}
