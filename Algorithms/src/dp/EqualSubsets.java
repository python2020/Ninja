package dp;

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
	
	
	public static boolean canPartitionDP(int[] a) {
	    if (a == null) throw new NullPointerException();
	    
	    int total = 0;
	    for (int i = 0; i < a.length; i++) total += a[i];
	        
	    if ((total & 1) == 1) return false;
	    
	    
	    int half = total / 2;
	    boolean[] f = new boolean[half + 1]; // !
	    f[0] = true; // !
	    int curr;
	    for (int i = 0; i < a.length; i++) {
	    	curr = a[i];
	    	for (int j = half; j >= 0; j--) { 
	    		if (curr <= j)
	    			f[j] = f[j] || f[j-curr];
	    	}
	    }
	    
	    return f[half];		
	}
	
	
	public static void main(String[] args) {
		int[] a = {1, 3, 5, 7, 10};
		assert(EqualSubsets.canPartition(a));
		assert(EqualSubsets.canPartitionDP(a));
		
		int[] b = {1,10, 14};
		assert(EqualSubsets.canPartition(b) == false);
		assert(EqualSubsets.canPartitionDP(b) == false);
		
	}
}
