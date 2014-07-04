package stack;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class EvaluateInfixPolishNotation {
	// simple version: single digit
	public int eval(String exp) {
		exp = exp + ")"; // trick: for termination


		Set<Character> operSet = new HashSet<Character>();
		char[] opers = {'+', '-', '*', '/'};
		for (int i = 0; i < opers.length; i++) operSet.add(opers[i]);

		Stack<Integer> vstack = new Stack<Integer>();
		Stack<Character> ostack = new Stack<Character>();

		int length = exp.length(), f = 0, s = 0;
		char c;
		for (int i = 0; i < length; i++) {
			c = exp.charAt(i);

			if (operSet.contains(c)) {
				ostack.push(c);
			} else if (c == '(') {
				continue;
			} else if (c == ')') {
				s = vstack.pop();
				f = vstack.pop();

				switch(ostack.pop()) {
					case '+': vstack.push(f + s); break;
					case '-': vstack.push(f - s); break;
					case '*': vstack.push(f * s); break;
					case '/': vstack.push(f / s); break;
					default: break;
				}
			} else {
				vstack.push(c-'0');
			}
		}

		return vstack.pop();
	}

	public static void main(String[] args) {
		int v = (((2+5)*(6+1))-9)/4;
		String exp = "(((2+5)*(6+1))-9)/4";
		EvaluateInfixPolishNotation x = new EvaluateInfixPolishNotation();
		assert(x.eval(exp) == v);
	}
}
