package sorting;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;

// input: array of durations of task
// output: pairs of durations <a,b> s.t. a+b is minimized

public class OptimumTaskAssignment {
	public static List<List<Integer>> assign(ArrayList<Integer> A) {
		ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
		ArrayList<Integer> pair;
		
		for (int i = 0, j = A.size()-1; i < j; i++, j--) { 
			pair = new ArrayList<Integer>();
			pair.add(A.get(i));
			pair.add(A.get(j));
			res.add(pair);
		}
		return res;
	}


	public static void main(String[] args) {
		Random gen = new Random();
		int n;
		n = gen.nextInt(10000) + 1;
		
		ArrayList<Integer> A = new ArrayList<Integer>();
		for (int i = 0; i < n; ++i) {
			A.add(gen.nextInt(999));
		}
		List<List<Integer>> ps = assign(A);
		int max = Integer.MIN_VALUE, d;
		List<Integer> p;
		for (int i = 0; i < ps.size(); ++i) {
			p = ps.get(i);
			d = p.get(0) + p.get(1);
			if (d > max) max = d;
		}
		System.out.println(max);
	}
}
