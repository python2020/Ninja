package com.python2020.dp;

public class EditDistance {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();    
    
        int[] f = new int[n+1];
        for (int i = 0; i <= n; i++) f[i] = i;
        
        int diag = 0, tmp = 0;
        for (int i = 1; i <= m; i++) {
            f[0] = i;
            diag = i - 1;
            for (int j = 1; j <= n; j++) { 
                tmp = f[j];
                f[j] = Math.min(Math.min(f[j-1], f[j]) + 1, diag + (word1.charAt(i-1) == word2.charAt(j-1)? 0 : 1));
                diag = tmp;
            }
        }
        
        return f[n];  
    }
}
