package com.python2020.dp;

public class ClimbingStairs {
    public int climbStairs(int n) {
        if (n == 1) return 1;
        
        int b2 = 1, b1 = 1, b = 0;
        for (int i = 2; i <= n; i++) {
            b = b2 + b1;
            b2 = b1;   // ordered
            b1 = b;
        }
        
        return b;
    }
}
