package search;

public class SearchTwoDimMatrix {
	public boolean searchMatrix(int[][] matrix, int target) {

		int l = 0;
		int h = matrix.length - 1;
		int m = 0, v = 0;

		while (l <= h) {
			m = l + ((h - l) >> 1); 
			v = matrix[m][0];
	
			if (v == target) return true;
			if (v > target) h = m - 1;
			else l = m + 1;
		}

		if (h == -1) return false; // 1

		int[] row = matrix[h]; // 2
		l = 0;
		h = matrix[0].length - 1;

		while (l <= h) {
			m = l + ((h - l) >> 1);
			v = row[m];
	
			if (v == target) return true;
			if (v > target) h = m - 1;
			else l = m + 1;
		}

		return false;            
	}
}
