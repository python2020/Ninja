package numbers;

public class Division {
	public int divide(int dividend, int divisor) {
		if (divisor == 0) throw new IllegalArgumentException();

		long dd = dividend, ds = divisor;

		boolean neg = false;
		if (dd < 0) { neg = !neg; dd = -dd; }
		if (ds < 0) { neg = !neg; ds = -ds; }

		int shift = 0;
		while (dd >= (ds << shift) ) shift++;
		shift--;

		long res = 0;

		while (dd >= ds) {
			if (dd >= (ds << shift)) { 
				res |= 1 << shift;
				dd -= ds << shift;
			}
			shift--;    
		}

		if (res > Integer.MAX_VALUE) return neg? Integer.MIN_VALUE : Integer.MAX_VALUE;

		return (int) (neg? -res : res);         
	}

	public String toBinaryString(int n) {
		StringBuffer bf = new StringBuffer();
		for (int i = 31; i >= 0; i--) {
			//System.out.println((char) (( (n & (1 << i)) ==0? 0 : 1) + '0'));
			bf.append((char) (( (n & (1 << i)) ==0? 0 : 1) + '0'));
		}
		return bf.toString();
	}

	public static void main(String[] args) {
		System.out.println(Integer.MAX_VALUE + " " + Integer.MIN_VALUE);
		Division x = new Division();
		long l = 1L;
		System.out.println(l << 33);
		System.out.println(x.divide(2147483647, 1));
		int a = -16;
		System.out.println(x.toBinaryString(a));
		a = a >> 2;
		System.out.println(x.toBinaryString(a));
	}
}
