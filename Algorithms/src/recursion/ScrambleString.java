package recursion;

import java.util.Arrays;

public class ScrambleString {
    public boolean isScramble(String s1, String s2) {
    	if (s1.length() != s2.length()) return false;
    	return isScrambleHelper(s1, s2);
    }
        
    public boolean isScrambleHelper(String s1, String s2) {
    	if (s1.equals(s2)) return true;
    	
    	// Compare signatures 
    	char[] c1 = s1.toCharArray(), c2 = s2.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        String ss1 = new String(c1), ss2 = new String(c2);
        if (!ss1.equals(ss2)) return false;
    	
        // Try all possible split positions
        int length = s1.length();
    	String s1a, s1b;
    	for (int i = 1; i < length; i++) {
    		s1a = s1.substring(0, i);
    		s1b = s1.substring(i);
    		if (	(isScrambleHelper(s1a, s2.substring(0, i)) 
    					&& isScrambleHelper(s1b, s2.substring(i))) 
    			||  (isScrambleHelper(s1a, s2.substring(length-i)) 
    					&& isScrambleHelper(s1b, s2.substring(0, length-i))) )
    		return true;
    	}
		return false;
    }
    
    public static void main(String[] args) {
    	ScrambleString x = new ScrambleString();
    	String s1 = "", s2 = "";
    	assert(x.isScramble(s1, s2));
    }
}
