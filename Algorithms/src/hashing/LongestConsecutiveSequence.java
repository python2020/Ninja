package hashing;

import java.util.HashSet;

public class LongestConsecutiveSequence {
	public class Solution {
		public int longestConsecutive(int[] num) {

			HashSet<Integer> notvisited = new HashSet<Integer>();
			for (int i = 0; i < num.length; i++) notvisited.add(num[i]);

			int x = 0, maxlen = 0, length = 0, l = 0, r = 0;
			for (int i = 0; i < num.length; i++) {
				x = num[i];
				if (notvisited.contains(x)) {
					notvisited.remove(x);
					length = 1;

					l = x - 1;
					while (notvisited.contains(l)) {
						notvisited.remove(l);
						l--;
						length++;
					}

					r = x + 1;
					while (notvisited.contains(r)) {
						notvisited.remove(r);
						r++;
						length++;
					}

					if (length > maxlen) maxlen = length;                    
				}


			}

			return maxlen;        
		}
	}
}
