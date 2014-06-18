package strings;

public class MultiplyStrings {
	public String multiply(String num1, String num2) {
		int e1 = num1.length() - 1;
		int e2 = num2.length() - 1;
		int s1 = 0, s2 = 0;

		boolean isNeg = false;
		char c = num1.charAt(0);
		if (c == '-') {
			isNeg = !isNeg;
			s1++;
		} else if (c == '+') {
			s1++;
		}

		c = num2.charAt(0);
		if (c == '-') {
			isNeg = !isNeg;
			s1++;
		} else if (c == '+') {
			s1++;
		}

		int e3 = e1 + e2;
		int[] t = new int[e3-s1-s2 + 3];
		for (int i = e1; i >= s1; i--) 
			for (int j = e2; j >= s2; j--) 
				t[e3-i-j] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');

		for (int i = 0; i < t.length-1; i++) {
			t[i+1] += t[i] / 10;
			t[i] %= 10;
		}

		StringBuilder s = new StringBuilder();
		if (isNeg) s.append('-');

		int k = t.length-1;
		while (k >= 1 && t[k] == 0) k--; // skip leading zeros (except the only 0)

		for (; k >= 0; k--) { 
			s.append((char) (t[k] + '0')); // cast!
		}

		return s.toString();
	}
}
