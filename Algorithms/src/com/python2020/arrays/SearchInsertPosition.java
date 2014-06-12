package com.python2020.arrays;

public class SearchInsertPosition {
    public int searchInsert(int[] A, int target) {
        int l = 0, h = A.length-1, m = 0, v = 0;
        
        while (l <= h) {
            m = (l + h) >> 1;
            v = A[m];
            
            if (v < target) {
                l = m + 1;
            } else if (v > target) {
                h = m - 1;
            } else {
                return m;    
            }
        }
        
        return l;
    }
}
