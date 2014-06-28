package arrays;

import java.util.Arrays;

public class ThreeSumClosest {
	public int threeSumClosest(int[] num, int target) {
		if (num == null || num.length < 3) return 0;
		Arrays.sort(num);
		int minDiff = Integer.MAX_VALUE, sum = num[0] + num[1] + num[2];

		int target2 = 0;
		for (int i = 0, j = 0, k = 0, diff = 0; i < num.length - 2; i++) {
			target2 = target - num[i];
			
			j = i + 1;
			k = num.length - 1;

			while (j < k) {
				diff = target2 - num[j] - num[k];

				if (Math.abs(diff) < minDiff) {
					minDiff = Math.abs(diff);
					sum = num[i] + num[j] + num[k];
				} // before the above!

				if (diff < 0) { // target2 is smaller
					k--;
				} else if (diff > 0) {
					j++;
				} else {
					return target;            
				}
			}

		}

		return sum;
    }

	public static void main(String[] args) {
    	ThreeSumClosest x = new ThreeSumClosest();
    	int[] num = {-1, 2, 1, -4};
    	
    	int target = 1;
    	System.out.println(x.threeSumClosest(num, target));
    }
}
