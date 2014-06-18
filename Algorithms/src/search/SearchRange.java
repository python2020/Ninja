package search;

public class SearchRange {
	public int[] searchRange(int[] A, int target) {

		int[] result = new int[2];
		result[0] = -1;
		result[1] = -1;

		int l = 0, h = A.length - 1, m, mv;

		while (l <= h) {
			m = (l + h) / 2;
			mv = A[m];

			if (mv == target) {
				result[0] = m;
				h = m - 1;
			} else if (mv < target) {
				l = m + 1;
			} else {
				h = m - 1;
			}
		}

		l = result[0];
		if (l == -1) 
			return result;

		h = A.length - 1;

		while (l <= h) {
			m = (l + h) / 2;
			mv = A[m];

			if (mv == target) {
				result[1] = m;
				l = m + 1;
			} else if (mv < target) {
				l = m + 1;
			} else {
				h = m - 1;
			}            
		}

		return result; 

	}
}
