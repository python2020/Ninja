package arrays;

public class MergeSortedArray {
	public void merge(int A[], int m, int B[], int n) {
		int k = m + n - 1;
		m--;
		n--;

		while (m >= 0 && n >= 0) {
			if (A[m] >= B[n]) {
				A[k] = A[m];
				m--;
			} else {
				A[k] = B[n];
				n--;
			}
			k--;
		}

		while (n >= 0) {
			A[n] = B[n];
			n--;
		}
	}
}
