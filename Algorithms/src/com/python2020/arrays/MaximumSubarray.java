package com.python2020.arrays;

public class MaximumSubarray {
    public int maxSubArray(int[] A) {
        int maxSum = Integer.MIN_VALUE, sum = 0;
        for (int i = 0; i < A.length; i++) {
            if (sum < 0) sum = A[i];
            else sum += A[i];
            if (sum > maxSum) maxSum = sum;
        }    
        return maxSum;
    }
}
