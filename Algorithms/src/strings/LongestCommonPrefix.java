package strings;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null) return null;
        if (strs.length == 0) return "";
        
        String first = strs[0], s;
        int size = first.length(); 
        char c = 0;
        for (int i = 0; i < size; i++) {    
            c = first.charAt(i);
            for (int j = 1; j < strs.length; j++) {
                s = strs[j];
                if (s.length() == i || c != s.charAt(i)) return first.substring(0, i);
            }
        }
        
        return first;
    }
}
