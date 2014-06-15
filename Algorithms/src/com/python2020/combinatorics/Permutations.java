package com.python2020.combinatorics;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Permutations {
	
	// swapping
	public List<List<Integer>> permuteUnique(int[] num) {
		List<List<Integer>> results = new ArrayList<List<Integer>>();
		if (num == null || num.length == 0) return results;
		permuteUniqueHelper(0, num, results);
		return results;
	}
	
	public void permuteUniqueHelper(int p, int[] num, List<List<Integer>> results) {
		if (p == num.length) {
			ArrayList<Integer> a = new ArrayList<Integer>();
			for (int i = 0; i < num.length; i++) a.add(num[i]);
			results.add(a);
			return;
		}

		Set<Integer> mySet = new HashSet<Integer>();
		for (int j = p, tmp; j < num.length; j++) {
			if (mySet.contains(num[j])) continue;         
			mySet.add(num[j]);
			tmp = num[p]; num[p] = num[j]; num[j] = tmp;
			permuteUniqueHelper(p+1, num, results);
			tmp = num[p]; num[p] = num[j]; num[j] = tmp; // backtrack              
		}
	} 

}
