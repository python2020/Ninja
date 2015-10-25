package strings;

import java.util.BitSet;

public class PalindromePermutation {
	// Method 2: https://leetcode.com/discuss/53180/1-4-lines-python-ruby-c-c-java
	public boolean canPermutePalindrome(String s) {
		BitSet bs = new BitSet();
		for (byte b : s.getBytes()) // Encodes this String into a sequence of bytes using the named charset, storing the result into a new byte array. 
			bs.flip(b); 
		return bs.cardinality() < 2; // .cadinatily(): Returns the number of bits set to true in this BitSet
	}
	// Method 1
	public boolean canPermutePalindrome1(String s) {
		int[] map = new int[256];
		for (int i = 0; i < s.length(); i++) {
			map[s.charAt(i)]++;
		}
		int oddOccurCounter = 0;
		for (int i = 0; i < 256; i++) {
			if (((map[i]) & 1) == 1)
				oddOccurCounter++;
		}
		if ((s.length() & 1) == 1)
			return oddOccurCounter == 1;
		else
			return oddOccurCounter == 0;
	}

}
