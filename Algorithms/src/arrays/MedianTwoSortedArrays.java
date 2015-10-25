package arrays;


public class MedianTwoSortedArrays {
	double findMedianSortedArrays(int A[], int B[]) {  
		int m = A.length, n = B.length, total = m + n, k = total >> 1;  
		
		if ((total & 1) == 1)
			return findKth(A, 0, m, B, 0, n, k + 1);  
		else 
			return 0.5 * (findKth(A, 0, m, B, 0, n, k) + 
					findKth(A, 0, m, B, 0, n, k + 1)) ;
	} 

	double findKth(int a[], int astart, int asize, int b[], int bstart, int bsize, int k) {  
		if (asize == 0) return b[k-1]; 

		if (asize > bsize)  
			return findKth(b, bstart, bsize, a, astart, asize, k);          

		if (k == 1) 
			return Math.min(a[astart], b[bstart]);  

		
		int anum = Math.min(k/2, asize);
		int bnum = k - anum;  

		int ak2 = a[astart + anum - 1];
		int bk2 = b[bstart + bnum - 1];


		if (ak2 < bk2)  // the rank (in the merged array) of k2InA is at most k-1, so all left a elements are of lower rank!
			return findKth(a, astart + anum, asize - anum, b, bstart, bsize, k - anum); // pa elements were eliminated

		else if (ak2 > bk2)  
			return findKth(a, astart, asize, b, bstart + bnum, bsize - bnum, k - bnum);  

		else  
			return ak2;  
	}


	public static void main(String[] args) {
		MedianTwoSortedArrays x = new MedianTwoSortedArrays();
		int[] a = {1,2,3};
		int[] b = {1};
		System.out.println(x.findMedianSortedArrays(a, b));

	}
}
