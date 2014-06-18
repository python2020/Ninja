package combinatorics;

import java.util.ArrayList;
import java.util.Collections;
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
	
	public static int rank(ArrayList<Integer> perm) {
		ArrayList<Integer> indexes = (ArrayList<Integer>) perm.clone();
		Collections.sort(indexes);
		return rank(perm, indexes, 0);
	}
	
	public static int rank(ArrayList<Integer> perm, ArrayList<Integer> indexes, int p) {	
		int numLeft = perm.size() - p - 1;
		if (numLeft == 0) return 0;
		
		int index = indexes.indexOf(perm.get(p)); // "rank" of perm.get(p)
		indexes.remove(index);
		int fact = 1;
		
		while (numLeft > 1) { 
			fact *= numLeft;
			numLeft--;
		}
		
		return index * fact + rank(perm, indexes, p+1);
	}
	
	public static void main(String[] args) {
		ArrayList<Integer> perm = new ArrayList<Integer>();
		int[] a = {2,1,3,4,5};
		for (int i = 0; i < a.length; i++) perm.add(a[i]);
		assert(Permutations.rank(perm) == 24);
	}
}
