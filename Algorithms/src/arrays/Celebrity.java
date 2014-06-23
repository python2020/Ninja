package arrays;

import java.util.Random;

public class Celebrity {

	public static int findCelebrity(int[][] matrix) { 
		int i = 0, j = 0;
		while (i < matrix.length) {
			for (j = i + 1; j < matrix.length; ) {
				if (matrix[i][j] == 0) j++;
				else break;
			}
			if (j == matrix.length) return i;
			i = j;
		}
		return 0;
	}

	public static void main(String[] args) {
		int N = 25;
		Random r = new Random();
		int c = r.nextInt(N);
		System.out.println(c);

		// the chance of >= celebrities is very slim
		int[][] matrix = new int[N][N];
		for (int i = 0; i < N; i++) {

			for (int j = 0; j < N; j++) {
				if (i == j) matrix[i][j] = 1;
				else if (i != c) {
					if (j == c) matrix[i][j] = 1;
					else matrix[i][j] = r.nextInt(2);
				}
				System.out.print(matrix[i][j] + " ");
			}

			System.out.println();
		}

		assert(c == findCelebrity(matrix));
		System.out.println(c + " "+ findCelebrity(matrix));
	}

}
