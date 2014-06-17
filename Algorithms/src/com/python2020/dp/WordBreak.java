package com.python2020.dp;

import java.util.Set;

public class WordBreak {
	public boolean wordBreak(String s, Set<String> dict) {
		int length = s.length();

		boolean[] f = new boolean[length+1];
		f[0] = true;

		for (int i = 1; i <= length; i++) {
			for (int j = 1; j <= i; j++) {
				f[i] = f[i-j] && dict.contains(s.substring(i-j, i));
				if (f[i]) break;
			}
		}

		return f[length];    
	}
}
