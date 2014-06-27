package dp;

import java.util.List;
import java.util.ArrayList;

public class PalindromePartition {
    public void markPalin(String s, int l, int r, boolean[][] pm) {
        while (l >= 0 && r < pm.length)  // expanding 
            if (s.charAt(l) == s.charAt(r)) pm[l--][r++] = true;
            else break;
    }
    
    public void markPalin(boolean[][] pm, String s) { // half matrix is used!
        for (int i = 0; i < pm.length; i++) {
            pm[i][i] = true;
            markPalin(s, i-1, i+1, pm); // i center
            markPalin(s, i, i+1, pm); // i and i+1 centers
        }
    }   
    
    public void constrRes(int k, String s, ArrayList<ArrayList<Integer>> fs, ArrayList<String> path, ArrayList<List<String>> res) {
        if (k == 0) {
            ArrayList<String> r = new ArrayList<String>();
            for (int i = path.size() - 1; i >= 0; i--) r.add(path.get(i)); // reverse
            res.add(r);
        } else {
            for (Integer i : fs.get(k)) {
                path.add(s.substring(i, k));
                constrRes(i, s, fs, path, res);
                path.remove(path.size() - 1);
            }   
        }
    }
    
    public List<List<String>> partition(String s) {
        int len = s.length();
        boolean[][] pmatrix = new boolean[len][len];
        markPalin(pmatrix, s); 
        
        ArrayList<ArrayList<Integer>> fs = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> f = new ArrayList<Integer>();
        fs.add(f);
        
        for (int i = 1; i <= len; i++) {
            f = new ArrayList<Integer>();
            fs.add(f);
            for (int j = 0; j < i; j++) if (pmatrix[j][i-1]) f.add(j); 
        }
        
        ArrayList<List<String>> res = new ArrayList<List<String>>();
        ArrayList<String> path = new ArrayList<String>();
        constrRes(len, s, fs, path, res);
        
        return res;
    }
    
    
    public int minCut(String s) {
        int len = s.length();
        boolean[][] pmatrix = new boolean[len][len];
        markPalin(pmatrix, s);
        
        int[] m = new int[len];
        for (int i = 0; i < len; i++) m[i] = i;
        
        for (int i = 1; i < len; i++) {
            if (pmatrix[0][i]) { 
                m[i] = 0;
                continue;
            }
            for (int j = 1; j <= i; j++) {
                if (pmatrix[i-j+1][i]) m[i] = Math.min(m[i], m[i-j]+1);
            }
        }
        
        return m[len-1];
    }
}
