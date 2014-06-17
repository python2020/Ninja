package com.python2020.arrays;

public class JumpGame {
    public boolean canJump(int[] A) {
    	int limit = 0, i = 0;
    	for ( ; limit < A.length && i <= limit && i < A.length; i++) 
    		limit = Math.max(limit, A[i] + i);
    	
    	return limit >= (A.length-1);        
    }	
	
	
	public int jump(int[] A) {
		int i = 0, steps = 0;
		int limit = 0, newLimit = 0;
		while (i < A.length && limit < A.length-1) { // neither reached the end
			newLimit = limit;
			while (i <= limit) {
				newLimit = Math.max(newLimit, A[i] + i);
				i++;
			}
			if (newLimit == limit) return 0;
			limit = newLimit;
			steps++;
		}

		return steps;
	}
}
