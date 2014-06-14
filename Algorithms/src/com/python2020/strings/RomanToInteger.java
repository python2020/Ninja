package com.python2020.strings;

import java.util.HashMap;

public class RomanToInteger {
	public int romanToInt(String s) {
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);

		int length = s.length();
		if (length == 0) return 0;

		int curr, prev = map.get(s.charAt(length-1)); 
		int result = prev;
		for (int i = length-2; i >= 0; i--) {
			curr = map.get(s.charAt(i));
			if (curr < prev) result -= curr;
			else result += curr;
			prev = curr;
		}

		return result;
	}
}
