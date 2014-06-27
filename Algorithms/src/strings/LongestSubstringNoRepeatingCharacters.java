package strings;


public class LongestSubstringNoRepeatingCharacters {
	
	// Method 1: store indexes (preferred) 
    public int lengthOfLongestSubstring(String s) {
    	
    	int left = 0, index, max = 0, length = s.length();
    	int[] ctoi = new int[128];    
        for (int i = 0; i < ctoi.length; i++) ctoi[i] = -1; // !
    	char c;
    	
    	for (int i = 0; i < length; i++) {
    		c = s.charAt(i);
    		index = ctoi[c];
    		
    		if (index >= left) {
    			max = Math.max(max, i - left);
    			left = index + 1;
    		}
    		
    		ctoi[c] = i;
    	}
    	
    	max = Math.max(max, length - left);
    	
		return max;
    }
    
    
    // Method 2: store booleans
    public int lengthOfLongestSubstring2(String s) {
        int length = s.length();
        if (length == 0) return 0;
        
        boolean[] covered = new boolean[128];
        
        int max = 0;
        char c;
        int l = 0;
        for (int r = 0; r < length; r++) {
            c = s.charAt(r);
            if (covered[c]) {
                max = Math.max(max, r - l);
                
                while (s.charAt(l) != c) 
                    covered[s.charAt(l++)] = false;
                
                l++;    
                
            } else {
                covered[c] = true;
            }
        }
        
        max = Math.max(max, length - l);
        
        return max;    
    }
}
