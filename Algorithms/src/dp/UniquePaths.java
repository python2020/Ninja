package dp;

public class UniquePaths {
	public int uniquePaths(int m, int n) {
		// f[i][j] = f[i][j-1] + f[i-1][j]
		// f[0][j] = 1 for j = 0:n
		// f[i][0] = 1 for i = 0:m

		int[] f = new int[n];
		for (int i = 0; i < n; i++)
			f[i] = 1;

		for (int i = 1; i < m; i++)
			for (int j = 1; j < n; j++)
				f[j] = f[j-1] + f[j];

		return f[n-1];        
	}


	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int m = obstacleGrid.length, n = obstacleGrid[0].length;
		int[] f = new int[n];
		f[0] = 1 - obstacleGrid[0][0];

		for (int i = 1; i < n; i++) 
			f[i] = f[i-1] * (1 - obstacleGrid[0][i]);

		for (int i = 1; i < m; i++) {
			f[0] = f[0] * (1 - obstacleGrid[i][0]); 
			for (int j = 1; j < n; j++) 
				f[j] = (f[j-1] + f[j]) * (1 - obstacleGrid[i][j]);   
		}

		return f[n-1];    
	}
}
