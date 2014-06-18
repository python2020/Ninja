package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
	public List<List<Integer>> threeSum(int[] num) {
		if (num == null) return null;

		Arrays.sort(num);
		
		ArrayList<List<Integer>> results = new ArrayList<List<Integer>>();
		ArrayList<Integer> result;
		int target, sum2, j, k;

		for (int i = 0; i <= num.length-3;) {
			target = -num[i];
			j = i + 1;
			k = num.length - 1;

			while (j < k) {
				sum2 = num[j] + num[k];
				if (sum2 > target) {
					k--;
					while (j < k && num[k] == num[k+1]) k--;
				} else if (sum2 < target) {
					j++;
					while (j < k && num[j] == num[j-1]) j++;
				} else {
					result = new ArrayList<Integer>();

					result.add(num[i]);
					result.add(num[j]);
					result.add(num[k]);

					results.add(result);

					k--;
					while (j < k && num[k] == num[k+1]) k--;
					j++;
					while (j < k && num[j] == num[j-1]) j++;                    
				}
			}

			i++;
			while (i <= num.length-3 && num[i] == num[i-1]) i++; 
		}

		return results;
	}
}
