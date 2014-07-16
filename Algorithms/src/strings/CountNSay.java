package strings;

public class CountNSay {
    public static String countAndSay(int n) {
        
        String s = "1";
        StringBuilder sb = new StringBuilder();
        int k = 1, cnt;
        char c = 0;
        
        while (k < n) {
            sb.setLength(0);
            
            // count
            c = s.charAt(0);
            cnt = 1;
            for (int i = 1; i < s.length(); i++) { // from 1
                if (s.charAt(i) != c) {
                    sb.append((char) (cnt + '0')); // cnt is at most 3?
                    sb.append(c); 
                    
                    c = s.charAt(i);
                    cnt = 1;
                } else {
                    cnt++;
                }
            }
            sb.append((char) (cnt + '0'));
            sb.append(c);
            
            // say
            s = sb.toString();
            
            k++; // kth
        }
        
        return s;
    }
    
    public static void main(String[] args) {
    	System.out.println(countAndSay(14));
    }
}
