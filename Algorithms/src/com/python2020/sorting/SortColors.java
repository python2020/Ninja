package com.python2020.sorting;

public class SortColors {
	public void sortColors(int[] A) {
		if (A == null) return;

		int tail0 = -1, head2 = A.length;
		for (int i = 0, v; i < head2; ) {
			v = A[i];
			if (v == 0) {
				tail0++;
				if (tail0 != i) {
					A[tail0] = 0;
					A[i] = 1;
				}
			} else if (v == 2) {
				head2--;
				if (head2 != i) {
					A[i] = A[head2]; // need to check A[i] for the next round 
					A[head2] = 2;
				}
				continue;
			}
			i++;
		}
	}
}
