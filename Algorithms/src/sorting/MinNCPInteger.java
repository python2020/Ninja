package sorting;

public class MinNCPInteger {
	/*
	 * if 1...S is the "solution" to subarray a0...a_{i-1}
	 * when ai is included 
	 * 	if ai <= S + 1, then S = S + ai, continue 
	 *	else return S+1
	 */
	
	public int minNCPInteger(int[] A) {
		int S = 0;
		for (int i = 0; i < A.length; i++) 
			if (A[i] <= S + 1) S = S + A[i];
			else break;
		return S + 1;
	}
}
