package arrays;

public class RotateImage {
	public void rotate(int[][] matrix) {
		int n = matrix.length;

		int t;
		for (int i = 0; i < n; i++)
			for (int j = i + 1; j < n; j++) {
				t = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = t;
			}

		int m = n / 2;
		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++) {
				t = matrix[i][j];
				matrix[i][j] = matrix[i][n-1-j];
				matrix[i][n-1-j] = t;
			}
	}
}
