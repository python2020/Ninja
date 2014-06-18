package geometrics;

import java.util.HashMap;
import java.util.Map;

public class MaxPointsOnLine {
	public int maxPoints(Point[] points) {
		if (points == null) return 0;

		int gmax = 0, lmax = 0;
		Map<Double, Integer> slopeToCount = new HashMap<Double, Integer>();

		int horizontal = 0, vertical = 0, x1, y1, x2, y2;
		int duplicate = 0; // !
		Point p;
		double s;
		
		for (int i = 0; i < points.length; i++) {
			lmax = 1;
			horizontal = 1;
			vertical = 1;
			duplicate = 0;
			slopeToCount.clear();
			p = points[i];
			x1 = p.x;
			y1 = p.y;

			for (int j = i+1; j < points.length; j++) {
				p = points[j];
				x2 = p.x;
				y2 = p.y;

				if (y1 == y2) {
					if (x1 == x2) duplicate++; 
					else horizontal++;
				} else if (x1 == x2) { 
					vertical++;            
				} else {
					s = 1.0 * (y2-y1) / (x2-x1);
					Integer c = slopeToCount.get(s);
					if (c == null)  {
						slopeToCount.put(s, 2);
						if (lmax < 2) lmax = 2;
					} else {
						slopeToCount.put(s, c+1);  
						if (lmax < c+1) lmax = c+1;
					}
				}
			}

			if (lmax < horizontal) lmax = horizontal;
			if (lmax < vertical) lmax = vertical;
			lmax += duplicate;

			if (lmax > gmax) gmax = lmax;
		}

		return gmax;
	}
}
