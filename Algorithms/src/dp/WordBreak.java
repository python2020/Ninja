package dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {
	public boolean breakWords(String s, Set<String> dict) {
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

	public void constructResults(HashMap<Integer, ArrayList<Integer>> bptrs, String s, 
			int j, String partial, ArrayList<String> results) {
		if (j == 0) { 
			results.add(partial);
			return;
		}
		
		for (Integer i : bptrs.get(j)) {
			if (partial.isEmpty()) constructResults(bptrs, s, i, s.substring(i, j), results);
			else constructResults(bptrs, s, i, s.substring(i, j) + " " + partial, results);
		}
	}

	public List<String> breakWords2(String s, Set<String> dict) {
		int length = s.length();

		boolean[] f = new boolean[length+1];
		f[0] = true;
		HashMap<Integer, ArrayList<Integer>> bptrs = new HashMap<Integer, ArrayList<Integer>>();
		ArrayList<Integer> bptr = null;
		boolean b = false;
		for (int i = 1; i <= length; i++) {
			for (int j = 1; j <= i; j++) {
				b = f[i-j] && dict.contains(s.substring(i-j, i)); // !
				if (b) { // !
					f[i] = true;
					if (bptr == null) {
						bptr = new ArrayList<Integer>();
						bptrs.put(i, bptr);						
					}					
					bptr.add(i-j);
				}
			}
			bptr = null;
		}

		ArrayList<String> results = new ArrayList<String>();
		if (f[length]) constructResults(bptrs, s, length, "", results);  

		return results;
	}	

	public static void main(String[] args) {
		WordBreak x = new WordBreak();
		String s = "ab";
		Set<String> dict = new HashSet<String>();
		dict.add("a");
		dict.add("b");
		/*
    	dict.add("cat");
    	dict.add("cats");
    	dict.add("and");
    	dict.add("sand");
    	dict.add("dog");
		 */
		/*
    	dict.add("aaaaaaaaaa");
    	dict.add("aaaaaaaaa");
    	dict.add("aaaaaaaa");
    	dict.add("aaaaaaa");
    	dict.add("aaaaaa");
    	dict.add("aaaaa");
    	dict.add("aaaa");
    	dict.add("aaa");
    	dict.add("aa");
    	dict.add("a");
		 */
		assert(x.breakWords(s, dict));

		List<String> sents = x.breakWords2(s, dict);
		for (String sent : sents)
			System.out.println(sent);
	}	
}
