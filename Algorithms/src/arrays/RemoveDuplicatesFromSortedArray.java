package arrays;

public class RemoveDuplicatesFromSortedArray {
	public int removeDuplicates(int[] A) {
		if (A == null || A.length == 0) return 0;

		int slow = 0, fast = 1, f = 0;
		while (fast < A.length) {
			f = A[fast]; 
			if (f != A[slow]) A[++slow] = f;    
			fast++;
		}

		return slow+1;
	}

	public int removeDuplicatesTwice(int[] A) {
		if (A.length < 2) return A.length;

		int s = 0;
		boolean twice = false;
		for (int f = 1; f < A.length; f++) {
			if (A[s] == A[f]) {
				if (twice) continue;
				else twice = true;
			} else {
				twice = false;
			}
			s++;
			A[s] = A[f];
		}

		return s + 1;
	}

	public static void main(String[] args) {
		int[] A = {0,1,2,2,3,3,3,4,4,4,4};
		RemoveDuplicatesFromSortedArray x = new RemoveDuplicatesFromSortedArray();
		System.out.println(x.removeDuplicatesTwice(A));
	}
}
