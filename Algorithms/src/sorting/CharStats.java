package sorting;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class CharStats {
	// O(nlgn)
	public static void charFreq1(String s) {
		if (s.length() == 0) return;

		char[] sc = s.toCharArray();
		Arrays.sort(sc);
		
		int c = 1;
		char v = 0;
		for (int i = 1; i < sc.length; i++) {
			v = sc[i];
			if (v != sc[i-1]) {
				System.out.println(sc[i-1] + " " + c);
				c = 1;
			} else {
				c++;
			}
		}
		
		System.out.println(sc[sc.length-1] + " " + c);
	}
	
	// O(nlgn)
	public static void charFreq2(String s) {
		Map<Character, Integer> map = new TreeMap<Character, Integer>();
		
		char c = 0;
		Integer cnt = null; 
		for (int i = 0; i < s.length(); i++) {
			c = s.charAt(i);
			
			cnt = map.get(c);
			
			if (cnt == null) cnt = 1;
			else cnt += 1;
			
			map.put(c, cnt);			
		}
		
		for (Map.Entry<Character, Integer> entry: map.entrySet()) 
			System.out.println(entry.getKey() + " " + entry.getValue());
			
	}
	
	// O(n)
	public static void charFreq3(String s) {
		int[] cnt = new int[128];
		for (int i = 0; i < s.length(); i++)
			cnt[s.charAt(i)]++;			
		
		
		for (int i = 0; i < cnt.length; i++)
			if (cnt[i] != 0) System.out.println(((char) i) + " " + cnt[i]);
			
	}
	
	public static void main(String[] args) {
		//CharStats.charFreq1("enclosed is your new cash rewards credit card.");
		//System.out.println("\n\n");

		CharStats.charFreq3("enclosed is your new cash rewards credit card.");

	}
}
