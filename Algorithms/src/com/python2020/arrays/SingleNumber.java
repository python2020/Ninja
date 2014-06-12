package com.python2020.arrays;

public class SingleNumber {
    public int singleNumber(int[] A) {
        int result = A[0];
        for (int i = 1; i < A.length; i++) 
            result ^= A[i];
            
        return result;
    }
}
