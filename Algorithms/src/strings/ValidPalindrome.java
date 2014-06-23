package strings;

public class ValidPalindrome {
	public char isAlphanumeric(char c) {
		if ('a' <= c && c <= 'z') return c;
		if ('A' <= c && c <= 'Z') return Character.toLowerCase(c);
		if ('0' <= c && c <= '9') return c;
		return '*';
	}


	public boolean isPalindrome(String s) {
		if (s == null) return false;

		int l = 0, r = s.length() - 1;
		char lc, rc;
		while (l < r) {
			lc = s.charAt(l);
			lc = isAlphanumeric(lc);
			if (lc == '*') {
				l++;
				continue;
			}     

			rc = s.charAt(r);
			rc = isAlphanumeric(rc);
			if (rc == '*') {
				r--;
				continue;
			}

			if (rc != lc) return false;
			l++;
			r--; 
		}

		return true;
	}
}
