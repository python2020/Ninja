package com.python2020.dp;

public class DecodeWays {
    public int numDecodings(String s) {
        int length = s.length();
        if (length == 0) return 0;
        
        
        int[] f = new int[length+1];    
        // base cases
        f[0] = 1;
        int num = s.charAt(0) - '0';
        if (num > 0) f[1] = 1;
        
        
        String subStr;
        for (int i = 2; i <= length; i++) {
            num = s.charAt(i-1) - '0';
            if (num > 0) f[i] = f[i-1];
            
            subStr = s.substring(i-2, i);
            num = Integer.parseInt(subStr);
            if (0 < num && num <= 26 && subStr.equals(num + ""))
                f[i] += f[i-2];
        }
        
        return f[length];
    }
}
