package arrays;

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
