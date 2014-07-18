package strings;

public class RunLengthEncoding {
	public static String encode(String s) {
		if (s == null || s.length() == 0) return s;
		
		int cnt = 1;
		char c = s.charAt(0);
		StringBuilder sb = new StringBuilder();
		
		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i) == c) {
				cnt++;
			} else {
				sb.append(cnt); // !
				sb.append(c);

				c = s.charAt(i);
				cnt = 1;
			}
		}
		
		sb.append(cnt); // !
		sb.append(c);		
		
		return sb.toString();
	}

	public static String decode(String s) {
		if (s == null || s.length() == 0) return s;
		
		StringBuilder sb = new StringBuilder();
		int cnt = 0;
		char c = 0;
		for (int i = 0; i < s.length(); i++) {
			c = s.charAt(i);
			if (Character.isDigit(c)) { // !
				cnt = cnt * 10 + (c - '0'); // !
			} else {
				for (int j = 0; j < cnt; j++) 
					sb.append(c);
				
				cnt = 0;
			}
		}
		
		for (int j = 0; j < cnt; j++)  // ! 
			sb.append(c);
		
		return sb.toString();
	}
	
	public static void main(String[] args) {
	    assert ("aaaabcccaa".equals(decode("4a1b3c2a")));
	    assert ("4a1b3c2a".equals(encode("aaaabcccaa")));
	    
	    assert ("eeeffffee".equals(decode("3e4f2e")));
	    assert ("3e4f2e".equals(encode("eeeffffee")));
	    
	    assert ("aaaaaaaaaaffffee".equals(decode("10a4f2e")));
	    assert ("10a4f2e".equals(encode("aaaaaaaaaaffffee")));
	}
}
