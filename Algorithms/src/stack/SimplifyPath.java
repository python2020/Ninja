package stack;

import java.util.Stack;



public class SimplifyPath {
    public String simplifyPath(String path) {
        if (path == null) return null;
        
        int length = path.length();
        
        StringBuilder sb = new StringBuilder();
        char c;
        String dir;
        Stack<String> stack = new Stack<String>(); // linked list would be more efficient 
        for (int i = 0; i < length; i++) {
            c = path.charAt(i);
            if (c == '/') {
                dir = sb.toString();
                
                if (dir.equals("..")) {
                    if (!stack.isEmpty()) stack.pop();
                } else if (dir.length() != 0 && !dir.equals(".")) {
                	stack.push(dir);
                }
                
                sb = new StringBuilder();
            } else {
                sb.append(c);
            }
        }
        
        dir = sb.toString();
        if (dir.equals("..")) {
            if (!stack.isEmpty()) stack.pop();
        } else if (dir.length() != 0 && !dir.equals(".")) {
        	stack.push(dir);
        }
        
        
        String s = "";
        while (!stack.isEmpty()) s = "/" + stack.pop() + s;

        return s.isEmpty()? "/" : s;
    }
}
