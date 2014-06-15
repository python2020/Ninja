package com.python2020.arrays;

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
}
