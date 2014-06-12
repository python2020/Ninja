package com.python2020.trees;

public class UniqueBST {
	public int numTrees(int n) {
		if (n <= 1) return 1;
		int total = 0;
		for (int i = 1; i <= n; i++) {
			total += numTrees(i-1) * numTrees(n-i); // i => root
		}
		return total;
	}
}
