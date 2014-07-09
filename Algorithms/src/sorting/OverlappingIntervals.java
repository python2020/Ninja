package sorting;

import java.util.ArrayList;
import java.util.Collections;

public class OverlappingIntervals {
	public static class EndPoint implements Comparable<EndPoint> {
		int time;
		boolean isStart;
		
		public EndPoint(int t, boolean s) {
			time = t;
			isStart = s;
		}

		@Override
		public int compareTo(EndPoint e) {
			if (this.time == e.time) return this.isStart? 1 : -1;
			return this.time - e.time;
		}
	}
	
	public static int maxOverlapping(ArrayList<Interval> intervals) {
		
		ArrayList<EndPoint> endpoints = new ArrayList<EndPoint>();
		for (Interval v : intervals) { 
			endpoints.add(new EndPoint(v.start, true));
			endpoints.add(new EndPoint(v.end, false));
		}
		
		Collections.sort(endpoints);
		
		int max = 0, c = 0;
		for (EndPoint p : endpoints) {
			if (p.isStart) { 
				c++; 
			} else {
				max = Math.max(max, c);
				c--;
			}
			System.out.println(p.time + " " + c);
		}
		
		return max;	
	}
	
	public static void main(String[] args) {
		ArrayList<Interval> vs = new ArrayList<Interval>();
		vs.add(new Interval(2, 7));
		vs.add(new Interval(4, 5));
		vs.add(new Interval(1, 5));
		vs.add(new Interval(8, 9));
		vs.add(new Interval(6, 10));
		vs.add(new Interval(11, 13));
		vs.add(new Interval(9, 17));
		vs.add(new Interval(12, 15));
		vs.add(new Interval(14, 15));
		vs.add(new Interval(14, 16));
		vs.add(new Interval(15, 16));

		System.out.println("\n" +OverlappingIntervals.maxOverlapping(vs));
	}
}
