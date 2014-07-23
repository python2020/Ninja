package sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.NavigableMap;
import java.util.Random;
import java.util.TreeMap;

public class MaxIntersections {
	public static class Point implements Comparable<Point>  {
		int x, y1, y2;
		boolean isStart;
		boolean isVertical;
		
		public Point(int x, int y1, int y2, boolean s, boolean v) {
			this.x = x;
			this.y1 = y1;
			this.y2 = y2;
			isStart = s;
			isVertical = v;
		}

		@Override
		public int compareTo(Point e) {
			if (this.x == e.x) {
				if (isVertical && e.isVertical) {
					return y1 - e.y1;
				} else if (isVertical) {  // transitivity 
					if (e.isStart) return 1;
					else return -1;
				} else if (e.isVertical) { 
					if (isStart) return -1;
					else return 1;
				} else { // both are horizontal
					if (isStart && e.isStart) return 0;
					else if (isStart) return -1; // !!
					else if (e.isStart) return 1;
					else return 0;
				}
			}
			
			return this.x - e.x;
		}
	}
	
	public static int intersect(ArrayList<Bar> bars) {
		
		ArrayList<Point> pts = new ArrayList<Point>();
		for (Bar b : bars) { 
			//System.out.println(b.x1 + " " + b.y1 + " " + b.x2 + " " + b.y2);

			if (b.x1 == b.x2) { // vertical
				pts.add(new Point(b.x1, b.y1, b.y2, false, true));
				//System.out.println(b.x1 + " " + b.y1 + " " + b.y2);
			} else {
				pts.add(new Point(b.x1, b.y1, b.y2, true, false));
				//System.out.println(b.x1 + " " + b.y1 + " " + b.y2);
				pts.add(new Point(b.x2, b.y1, b.y2, false, false));
				//System.out.println(b.x2 + " " + b.y1 + " " + b.y2);
			}
		}
		
		Collections.sort(pts);
		
		TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
		
		//System.out.println();

		Integer cnt;
		int max = 0;
		for (Point p : pts) {
			//System.out.println(p.x + " " + p.y1 + " " + p.y2 + " " + p.isStart);
			if (p.isStart) { 
				cnt = map.get(p.y1);
				if (cnt == null) cnt = 0;
				map.put(p.y1, cnt + 1); 
			} else {
				if (p.isVertical) {
					NavigableMap<Integer, Integer> a = map.subMap(p.y1, true, p.y2, true);
					int sum = 0;
					for (Integer v : a.values()) sum += v; // !
					max = Math.max(max, sum); // !
				} else { // end point
					cnt = map.get(p.y1);
					if (cnt == 1) map.remove(p.y1);
					else map.put(p.y1, cnt-1);
				}
			}
		}
		
		return max;	
	}
	
	public static int intersectNaive(ArrayList<Bar> hbars, ArrayList<Bar> vbars) {
		int max = 0, cnt = 0;
		for (Bar vbar : vbars) {
			cnt = 0;
			for (Bar hbar : hbars) 
				if (hbar.x1 <= vbar.x1 && vbar.x1 <= hbar.x2 && vbar.y1 <= hbar.y1 && hbar.y1 <= vbar.y2) cnt++;
			if (cnt > max) max = cnt;
		}
		return max;
	}
	
	public static void test() {
		Random r = new Random();
		
		// horizontal
		ArrayList<Bar> hbars = new ArrayList<Bar>();
		int N = 100;
		int L = 30, H = 30;
		int x1 = 0, x2 = 0, y1 = 0, y2 = 0;
		for (int i = 0; i < N; i++) {
			x1 = r.nextInt(L);
			x2 = x1 + r.nextInt(L) + 1;
			y1 = r.nextInt(H);
			y2 = y1;
			hbars.add(new Bar(x1, y1, x2, y2));
			//System.out.println(x1 + " " + y1 + " " + x2 + " " + y2);
		}
		
		//System.out.println();

		ArrayList<Bar> vbars = new ArrayList<Bar>();
		HashSet<Integer> visited = new HashSet<Integer>();
		for (int i = 0; i < 20; i++) {
			x1 = r.nextInt(L);
			if (visited.contains(x1)) continue;
			x2 = x1;
			y1 = r.nextInt(H);
			y2 = y1 + r.nextInt(H) + 1;
			vbars.add(new Bar(x1, y1, x2, y2));
			//System.out.println(x1 + " " + y1 + " " + x2 + " " + y2);
		}		
		
		//System.out.println();
		
		ArrayList<Bar> bars = new ArrayList<Bar>();
		bars.addAll(hbars);
		bars.addAll(vbars);

		
		//System.out.println(intersectNaive(hbars, vbars) + " " + intersect(bars));
		assert(intersectNaive(hbars, vbars) == intersect(bars));
	}
	
	
	public static void main(String[] args) {
		for (int i = 0; i < 10000; i++) test();
	}
}
