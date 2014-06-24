package numbers;

public class Sqrt {
	public int sqrtNewton(int x) { 
		if (x <= 1) return x; 
		double mid = x / 2; 

		while ((int) Math.abs(x/mid - mid) != 0) { 
			mid = (mid + x / mid) / 2; 
		} 
		return (int) mid; 
	}

	public int sqrt(int x) {
		if (x < 0) return -1;
		int l = 1, h = x, m = 0, t = 0;
		while (l <= h) {
			m = (l + h) / 2;
			t = x / m; // avoid overflow
			if (t > m) {
				l = m + 1;
			} else if (t < m) {
				h = m - 1;
			} else {
				return t;
			}
		}	       
		return h; // good for x = 0;
	}

	public double sqrtNewton(double x) {
		double mid = x * .5; 
		double e = 0.0001;

		while (Math.abs(x-mid*mid) >= e) { 
			mid = (mid + x / mid) * 0.5; 
		} 
		return mid;   
	}

	public double sqrtBS(double x) {
		if (x < 0) return -1;

		if (x == 0 || x == 1) return x;

		double e = 0.0001;
		double l = 0, h = x, m = 0, t = 0;

		if (x < 1) h = 1;

		while (Math.abs(m*m - x) > e) {
			m = (l + h) / 2;
			t = x / m;
			
			if (t > m) {
				l = m;
			} else if (t < m) {
				h = m;
			} else {
				return m;
			}
		}

		return m;
	}


	public static void main(String[] args) {
		Sqrt x = new Sqrt();
		for (double num = 0.1; num < 1; num += 0.1) { 
			System.out.println(Math.abs(x.sqrtBS(num) - Math.sqrt(num)) < 0.0001);
			System.out.println(Math.abs(x.sqrtNewton(num) - Math.sqrt(num)) < 0.0001);
		}

	}

}
