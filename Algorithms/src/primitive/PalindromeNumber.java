package primitive;

public class PalindromeNumber {
	public boolean isPalindrome(int x) {
		if (x < 0) return false;

		int l = 1, n = x;
		while (n >= 10) {
			l *= 10;
			n /= 10;
		}

		int r = 1;
		while (l > r) {
			if (x / l % 10 == x / r % 10) {
				l /= 10;
				r *= 10;
			} else {
				return false;
			}
		}

		return true;
	}
}
