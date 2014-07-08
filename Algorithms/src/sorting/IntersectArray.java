package sorting;

import java.util.ArrayList;

public class IntersectArray {
	public static ArrayList<Integer> intersect(ArrayList<Integer> A, ArrayList<Integer> B) {
		
		int i = 0, j = 0, a, b, asize = A.size(), bsize = B.size();
		ArrayList<Integer> C = new ArrayList<Integer>();
		
		while (i < asize && j < bsize) {
			a = A.get(i);
			b = B.get(j);
			
			if (a < b) {
				i++;
			} else if (a > b) {
				j++;
			} else {
				C.add(a);
				
				do { i++; } while (i < asize && A.get(i) == a);
				do { j++; } while (j < bsize && B.get(j) == b);
			}
		}
		
		return C;
	}
	
	public static void main(String[] args) {
		int[] A = {1, 1, 1, 6, 6, 8, 9, 10, 18, 20};
		int[] B = {1, 6, 7, 7, 10, 17, 19, 20};
		
		ArrayList<Integer> l1 = new ArrayList<Integer>();
		for (int i = 0; i < A.length; i++) l1.add(A[i]);
		ArrayList<Integer> l2 = new ArrayList<Integer>();
		for (int i = 0; i < B.length; i++) l2.add(B[i]);
		
		for (Integer x : IntersectArray.intersect(l1, l2)) 
			System.out.print(x + " ");
		
	}
}
