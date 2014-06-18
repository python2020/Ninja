package recursion;

import java.util.ArrayList;

public class GenerateParentheses {
	public ArrayList<String> generateParenthesis(int n) {
		ArrayList<String> results = new ArrayList<String>();
		StringBuilder sb = new StringBuilder();

		generateHelper(n, n, sb, results);
		return results;
	}

	public void generateHelper(int nl, int nr, StringBuilder sb, ArrayList<String> results) {
		if (nl == 0) {
			if (nr == 0) {
				results.add(sb.toString());
				return;
			}
		} else {
			sb.append("(");
			generateHelper(nl-1, nr, sb, results);
			sb.deleteCharAt(sb.length() - 1);
		}
		if (nr > nl) {
			sb.append(")");
			generateHelper(nl, nr-1, sb, results);
			sb.deleteCharAt(sb.length() - 1);                
		}
	}
}
