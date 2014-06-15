package com.python2020.dp;

public class MinimunPathSum {
	public int minPathSum(int[][] grid) {
		// f[n] = min(f'[n], f'[n-1]) + grid[row][n]       
		// f[0] = f'[0] + grid[row][0]

		int m = grid.length, n = grid[0].length;
		int[] f = new int[n];

		f[0] = grid[0][0];
		for (int i = 1; i < n; i++) f[i] = f[i-1] + grid[0][i];

		for (int i = 1; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (j == 0) {
					f[0] += grid[i][0];
				} else {
					f[j] = Math.min(f[j-1], f[j]) + grid[i][j];
				}
			}
		}

		return f[n-1];
	}
}
