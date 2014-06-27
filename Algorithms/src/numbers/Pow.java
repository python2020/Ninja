package numbers;

public class Pow {
	public double pow(double x, int n) {
		boolean inv = false;
		if (x == 0) {
			if (n < 0) throw new IllegalArgumentException("Argument 'divisor' is 0");
			return 0;
		} else if (x == 1 || x == -1) {
			return (n & 1) == 1? x : Math.abs(x);
		}

		if (n < 0) { inv = true; n = -n; }

		return inv? 1 / powHelper(x, n) : powHelper(x, n);        
	}

	public double powHelper(double x, int n) {
		if (n == 0) return 1;
		double m = powHelper(x, n >> 1);
		return (n & 1) == 1? m * m * x : m * m;
	}
}
