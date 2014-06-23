package arrays;

public class MissingFirstPositive {
	public int firstMissingPositive(int[] A) {
		if (A == null) return 1;

		for (int i = 0, tmp = 0, v = 0; i < A.length;) {
			v = A[i];
			if (v <= 0 || v > A.length || A[v-1] == v) i++;
			else {
				tmp = A[v-1];
				A[v-1] = v;
				A[i] = tmp;
			}
		}

		for (int i = 0; i < A.length; i++) 
			if (A[i] != i + 1) return i + 1;

		return A.length + 1;
	}
}
