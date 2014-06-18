package primitive;

import java.util.Random;


public class DigitFive {
	public static int digitFiveSlow(int n) {
		//if (n < 0) throw new IllegalArgumentException();
		
		int counts = 0;
		for (int i = 4, m; i <= n; i++) {
			m = i;
			while (m > 4) {
				if (m % 10 == 5) {
					counts++;
					break;
				}
				m /= 10;
			}
		}
		
		return counts;
	}
	
	public static int digitFiveFast(int n) {
		//if (n < 0) throw new IllegalArgumentException();
		
		int m = n, divisor = 1;
		while (m > 10) {
			m /= 10;
			divisor *= 10;
		}
		return digitFiveFastHelper(n, divisor);
	}
	
	public static int digitFiveFastHelper(int n, int divisor) {
		if (n == 0) return 0;
		
		int digit = n / divisor;
		int remainder = n % divisor;
		int nextDivisor = divisor / 10;
		
		// counts associated with most significant digits
		int curCounts = digitFiveFastHelper(divisor-1, nextDivisor);
		
		// case 1
		if (digit == 5) return remainder + 1 + 5 * curCounts;
		
		// counts associated with remainder
		int remCounts = digitFiveFastHelper(remainder, nextDivisor);
		
		// case 2
		if (digit < 5) return digit * curCounts + remCounts;
		
		// case 3
		return divisor + (digit-1) * curCounts + remCounts;
		
	}
	
	public static void digitFiveTest() {
		assert(digitFiveFast(-10) == 0);
		assert(digitFiveFast(0) == 0);
		assert(digitFiveFast(55) == 11);
		assert(digitFiveFast(105) == 20);
		assert(digitFiveFast(1234567) == 562025);

		assert(digitFiveSlow(-10) == 0);
		assert(digitFiveSlow(0) == 0);
		assert(digitFiveSlow(55) == 11);
		assert(digitFiveSlow(105) == 20);
		assert(digitFiveSlow(1234567) == 562025);
		
	}

	public static void crossValidation() {		
		Random r = new Random();
		int range = 10000, n;
		int numSamples = 100;
		for (int i = 0; i <= numSamples; i++) {
			n = r.nextInt(range);
			assert(DigitFive.digitFiveSlow(n) == DigitFive.digitFiveFast(n));
		}			
	}
	
	public static void performaceComparison() {
		long startTime, endTime;
		int n = 100000000;//Integer.MAX_VALUE;
		
		startTime = System.currentTimeMillis();			
		System.out.println(digitFiveSlow(n));
		endTime = System.currentTimeMillis();
		System.out.println("Total execution time for \"Slow\": " + (endTime - startTime)  + "ms");

		
		startTime = System.currentTimeMillis();			
		System.out.println(digitFiveFast(n));
		endTime = System.currentTimeMillis();
		System.out.println("Total execution time for \"Fast\": " + (endTime - startTime)  + "ms");
	}
	
	public static void main(String[] args) {
		DigitFive.digitFiveTest();
		DigitFive.crossValidation();
		DigitFive.performaceComparison();
	}
}
