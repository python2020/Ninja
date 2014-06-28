package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public List<List<Integer>> fourSum(int[] num, int target) {
		Arrays.sort(num);
		ArrayList<List<Integer>> quadruplets = new ArrayList<List<Integer>>();
		ArrayList<Integer> quadruplet;
		int length = num.length, k, l, sum, t, twoTarget;
		
		for (int i = 0; i < length-3; i++) {
			for (int j = i+1; j < length-2; j++) { // i + 1
				k = j + 1; // k + 1
				l = length - 1; // l = length -1
				
				twoTarget = target - num[i] - num[j];
				
				while (k < l) {
					sum = num[k] + num[l];
					
					if (sum < twoTarget) k++;
					else if (sum > twoTarget) l--;
					else {
						quadruplet = new ArrayList<Integer>();
						quadruplet.add(num[i]);
						quadruplet.add(num[j]);
						quadruplet.add(num[k]);
						quadruplet.add(num[l]);
						quadruplets.add(quadruplet);
						
						t = num[k++];
						while (k < l && num[k] == t) k++; 
						if (k > l) break;
						
						t = num[l--];
						while (k <= l && num[l] == t) l--; 
					}
				}
				
				while (j+1 < length-2 && num[j] == num[j+1]) j++; 
			}
			
			while (i+1 < length-3 && num[i] == num[i+1]) i++; 
		}
		return quadruplets;        
    }

	public static void main(String[] args) {
		FourSum x = new FourSum();
		int[] num = {0, 0, 0, 0};
		int target = 0;
		List<List<Integer>> quadruplets = x.fourSum(num, target);
		for (List<Integer> a : quadruplets) {
			System.out.println(a.get(0) + " " + a.get(1) + " " + a.get(2) + " " + a.get(3));
		}
	}
}
