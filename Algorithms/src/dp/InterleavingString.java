package dp;

public class InterleavingString {
	public boolean isInterleave(String s1, String s2, String s3) {
		int l1 = s1.length(), l2 = s2.length(), l3 = s3.length();
		if (l1 + l2 != l3) return false;

		boolean[] f = new boolean[l2 + 1];
		f[0] = true;

		for (int j = 1; j <= l2; j++) f[j] = f[j-1] && (s2.charAt(j-1) == s3.charAt(j-1));

		for (int i = 1; i <= l1; i++) {
			f[0] = f[0] && (s1.charAt(i-1) == s3.charAt(i-1));

			for (int j = 1; j <= l2; j++) {
				f[j] = (f[j] && s1.charAt(i-1) == s3.charAt(i+j-1)) || 
						(f[j-1] && s2.charAt(j-1) == s3.charAt(i+j-1));
			}
		}

		return f[l2];    
	}

	public static void main(String[] args) {
		String s1 = "aabcc";
		String s2 = "dbbca";
		String s3 = "aadbbcbcac";
		InterleavingString x = new InterleavingString();
		assert(x.isInterleave(s1, s2, s3));
	}

}
