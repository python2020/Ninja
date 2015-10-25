package numbers;

public class AddDigits {
	public int addDigits(int num) {
		// n:           1,2,3,...,9
		// n mod 9:     1,2,3,...,0
		// expected:    1,2,3,...,9
		// (n-1) mod 9: 0,1,2,...,8

		return (num-1) % 9 + 1;
	}
}
