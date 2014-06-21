package search;

public class SearchRotatedSortedArray {
	
	
	
    public boolean searchWithDuplicates(int[] A, int target) {
        return searchHelper(A, 0, A.length-1, target);
    }
        
    public boolean searchHelper(int[] A, int l, int h, int target) {
        int m = 0, k;
        while (l <= h) {
            m = (l + h) >> 1;
            k = A[m];
            
            if (k == target) return true;
            if (k < A[h]) {
                if (k < target && target <= A[h]) l = m + 1;
                else h = m - 1;
            } else if (k > A[h]) { 
                if (A[l] <= target && target < k) h = m - 1;
                else l = m + 1;
            } else {
                if (A[l] == k) return searchHelper(A, l+1, m-1, target) 
                                        || searchHelper(A, m+1, h-1, target);
                else h = m - 1;
            }
        }
        
        return false;
    }
}
