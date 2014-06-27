package strings;


import java.util.HashMap;
import java.util.ArrayList;

public class SubstringConcatenationAllWords {
    public ArrayList<Integer> findSubstring(String S, String[] L) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (L == null || S == null || L.length == 0) return result;
    
        int totalLength = 0;
        int wordLength = L[0].length();
        
        HashMap<String, Integer> mapL = new HashMap<String, Integer>();
        Integer c = null;
        for (String word : L) {
            totalLength += word.length();
            c = mapL.get(word);
            if (c != null) mapL.put(word, c + 1);
            else mapL.put(word, 1);
        }              

        int last = S.length() - totalLength;
        for (int i = 0; i <= last; i++)
             match(i, totalLength, wordLength, S, mapL, result);

        return result;
     }
    
     public void match(int pos, int totalLength, int wordLength, String S, 
    		 HashMap<String, Integer> mapL, ArrayList<Integer> result) {
    
    	 HashMap<String, Integer> mapS = new HashMap<String, Integer>();
    	 String str = null;
    	 Integer lc = null, sc;
    	 for (int i = pos; i < pos + totalLength; i += wordLength) {
    		 str = S.substring(i, i + wordLength);
    		 lc = mapL.get(str);
    		 if (lc == null) return; // not in L

    		 sc = mapS.get(str);
    		 if (sc != null) {
    			 if (lc == sc) return; // counts already equal
    			 else mapS.put(str, sc + 1);
    		 } else {
    			 mapS.put(str, 1);
    		 }   
    	 }
    	 result.add(pos);
    }
     
    public static void main(String[] args) {
    	SubstringConcatenationAllWords x = new SubstringConcatenationAllWords();
    	String S = "lingmindraboofooowingdingbarrwingmonkeypoundcake";//"barfoothefoobarman";
    	String[] L = {"fooo","barr","wing","ding","wing"}; //{"foo", "bar"};
    	ArrayList<Integer> offsets = x.findSubstring(S, L);
    	for (int i = 0; i < offsets.size(); i++) {
    		System.out.println(offsets.get(i));
    	}
    }
}
