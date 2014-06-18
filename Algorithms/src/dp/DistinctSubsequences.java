package dp;

public class DistinctSubsequences {
	public int numDistinct(String S, String T) {
		int m = S.length(); 
		int n = T.length();
		if (m < n) return 0; 

		int[] f = new int[n+1];
		f[0] = 1;

		for (int i = 0; i < m; i++) 
			for (int j = n; j > 0; j--) 
				f[j] += (S.charAt(i) == T.charAt(j-1)? f[j-1] : 0); 

		return f[n];          
	}
}
