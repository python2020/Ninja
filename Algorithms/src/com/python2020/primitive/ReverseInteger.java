package com.python2020.primitive;

public class ReverseInteger {
	public int reverse(int x) {
		long lx = x, result = 0L;

		// sign
		boolean pos = true;
		if (lx < 0) {
			pos = false;
			lx = -lx;
		}

		while (lx > 0) {
			result = result * 10 + lx % 10;
			lx /= 10;
		}

		return (int) (pos? result : -result);
	}
}
