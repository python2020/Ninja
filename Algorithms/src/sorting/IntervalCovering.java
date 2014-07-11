package sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

public class IntervalCovering {
	public static class ExInterval extends Interval {
		boolean checked;
		
		public ExInterval(int s, int e) { // !
			super(s, e);
			checked = false;//
		}
	}
	
	public static ArrayList<Integer> minVisits(ArrayList<Interval> vs) {
		ArrayList<ExInterval> sts = new ArrayList<ExInterval>();
		ArrayList<ExInterval> ens = new ArrayList<ExInterval>();
		
		ExInterval exv = null;
		for (Interval v : vs) {
			exv = new ExInterval(v.start, v.end);
			sts.add(exv);
			ens.add(exv);
		}
		
		Comparator<ExInterval> cs = new Comparator<ExInterval>() {
			@Override
			public int compare(ExInterval v1, ExInterval v2) {
				return v1.start - v2.start;
			}
		};

		Comparator<ExInterval> ce = new Comparator<ExInterval>() {
			@Override
			public int compare(ExInterval v1, ExInterval v2) {
				return v1.end - v2.end;
			}
		};
		
		Collections.sort(sts, cs);
		Collections.sort(ens, ce);
		
		ArrayList<Integer> res = new ArrayList<Integer>();
		int i = 0, size = vs.size();
		ExInterval st = null;
		for (ExInterval en : ens) {
			if (!en.checked) {
				//System.out.println("end:" + en.end);
				res.add(en.end);
				
				while (i < size) {
					st = sts.get(i);
					//System.out.println("start:" + st.start);
					
					if (st == en || st.start < en.end) { // !
						//System.out.println("start checked:" + st.start);
						i++;
						st.checked = true;
					} else { 
						break;
					}
				}
			}
		}
		
		return res;
	}
	
	
	// Test functions copied from https://github.com/epibook/epibook.github.io/blob/master/solutions/java/src/main/java/com/epi/PointsCoveringIntervalsAlternative.java
	// O(n^2) checking solution
	public static void checkAnswer(ArrayList<Interval> intervals,
			ArrayList<Integer> answer) {
		boolean[] isVisited = new boolean[intervals.size()];
		for (Integer a : answer) {
			for (int i = 0; i < intervals.size(); ++i) {
				if (a >= intervals.get(i).start && a <= intervals.get(i).end) {
					isVisited[i] = true;
				}
			}
		}

		for (boolean b : isVisited) {
			assert (b == true);
		}
	}

	public static void simpleTest() {
		ArrayList<Interval> intervals = new ArrayList<Interval>();
		intervals.add(new Interval(1, 4));
		intervals.add(new Interval(2, 8));
		intervals.add(new Interval(3, 6));
		intervals.add(new Interval(3, 5));
		intervals.add(new Interval(7, 10));
		intervals.add(new Interval(9, 11));
		ArrayList<Integer> ans = minVisits(intervals);
		assert (ans.size() == 2 && ans.get(0) == 4 && ans.get(1) == 10);
	}

	public static void main(String[] args) {
		simpleTest();
		Random gen = new Random();
		for (int times = 0; times < 1000; ++times) {
			System.out.println("Test " + times);
			int n;
			//if (args.length == 1) {
			//	n = Integer.parseInt(args[0]);
			//} else {
				n = gen.nextInt(10000) + 1;
			//}
			ArrayList<Interval> intervals = new ArrayList<Interval>();
			for (int i = 0; i < n; ++i) {
				int left = gen.nextInt(9999);
				int right = gen.nextInt(left + 100) + left + 1;
				intervals.add(new Interval(left, right));
			}
			ArrayList<Integer> ans = minVisits(intervals);
			checkAnswer(intervals, ans);
		}
	}
}
