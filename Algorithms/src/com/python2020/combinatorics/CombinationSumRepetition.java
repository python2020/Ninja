package com.python2020.combinatorics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumRepetition {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		ArrayList<List<Integer>> results = new ArrayList<List<Integer>>();
		ArrayList<Integer> result = new ArrayList<Integer>();

		Arrays.sort(candidates);
		combinationSumHelper(candidates, target, 0, result, results);

		return results;    
	}

	public void combinationSumHelper(int[] candidates, int target, int p, ArrayList<Integer> result, ArrayList<List<Integer>> results) {
		if (target == 0) {
			results.add((ArrayList<Integer>) result.clone());
			return;
		}

		int curr = 0;
		for (int i = p; i < candidates.length; i++) {
			curr = candidates[i];
			if (curr > target) break;

			if (i == p || curr != candidates[i-1]) {
				result.add(curr);
				combinationSumHelper(candidates, target-curr, i, result, results);
				result.remove(result.size() - 1);
			}
		}
	}
}
