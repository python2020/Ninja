package primitive;

public class SingleNumber {
	public int singleNumber(int[] A) {
		int result = A[0];
		for (int i = 1; i < A.length; i++) 
			result ^= A[i];

		return result;
	}

	int singleNumber2(int[] A) {
		int n0 = 0, n1 = 0, n2 = 0, m;
		for (int i = 0; i < A.length; ++i) {
			m = A[i];
			n0 = ~(n1 | n2); // if the remainder is neither 1 or 2, then set 0 
			n2 = (n2 & ~m) | (n1 & m); // if (r is 2 and m_bit is 0) or (r is 1 and m_bit is 1), then set 2
			n1 = (n1 & ~m) | (n0 & m);
		}
		return n1;
	}
}
