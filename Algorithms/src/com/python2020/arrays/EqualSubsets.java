package com.python2020.arrays;

public class EqualSubsets {
	public static boolean canPartition(int[] a) {
	    if (a == null) throw new NullPointerException();
	    
	    int total = 0;
	    for (int i = 0; i < a.length; i++) 
	        total += a[i];
	        
	    if ((total & 1) == 1) return false;
	    
	    return canPartitionHelper(a, total/2, 0);
	}  


	public static boolean canPartitionHelper(int[] a, int sum, int p) {
	    int curr;
	    for (int i = p; i < a.length; i++) {
	        curr = a[i];
	        if (curr == sum) return true;
	        if (canPartitionHelper(a, sum-curr, i+1)) return true;
	        //if (canPartitionHelper(a, sum, i+1)) return true;
	    }
	    return false; 
	}
	
	
	public static void main(String[] args) {
		int[] a = {1, 3, 5, 7, 10};
		assert(EqualSubsets.canPartition(a));
		
		int[] b = {1,10, 14};
		assert(EqualSubsets.canPartition(b) == false);
	}
}
