package java.python2020.stack;

import java.util.HashSet;
import java.util.Stack;
import java.util.Set;

public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        // error check
        if (tokens == null || tokens.length == 0) return 0;
       
        Stack<Integer> stack = new Stack<Integer>();
        Set<String> operSet = new HashSet<String>();
        operSet.add("*");
        operSet.add("/");
        operSet.add("+");
        operSet.add("-");
        
        int f, s;
        for (String token : tokens) {
            if (operSet.contains(token)) {
                // assume the input is always valid
                s = stack.pop();
                f = stack.pop();
                switch (token) {
                    case "*": 
                        stack.push(f * s);
                        break;
                    case "/":
                        stack.push(f / s);
                        break;
                    case "+":
                        stack.push(f + s);
                        break;
                    case "-": 
                        stack.push(f - s);
                        break;
                    default: 
                        break;
                }
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        
        // final result is in the stack
        return stack.pop();
    }
}
