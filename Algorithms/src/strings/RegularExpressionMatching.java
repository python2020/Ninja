package strings;

public class RegularExpressionMatching {
	public boolean isMatch(String s, String p) {
		return isMatchedHelp(s, 0, p, 0);
	}

	public boolean isMatchedHelp(String s, int si, String p, int pi) {
		int slen = s.length();
		int plen = p.length();
		if (pi == plen) {
			if (si == slen) return true;
			else return false;
		}

		char cp = p.charAt(pi);

		if (pi+1 < plen && p.charAt(pi+1) == '*') {
			pi += 2;
			if (isMatchedHelp(s, si, p, pi)) return true;

			for (int i = 0; si+i < slen; i++) {
				if (cp == '.' || cp == s.charAt(si+i)) {
					if (isMatchedHelp(s, si+i+1, p, pi)) return true;
				}
				else break;
			}
		}
		else {
			if (si == slen) return false;
			if (cp == '.' || cp == s.charAt(si)) 
				return isMatchedHelp(s, si+1, p, pi+1);
		}
		return false;
	}
}
