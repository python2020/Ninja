package com.python2020.arrays;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
	public int[] twoSum(int[] numbers, int target) {
		int[] res = new int[2];
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		Integer index;
		for (int i = 0, n; i < numbers.length; i++) {
			n = numbers[i];
			index = map.get(n);
			if (index == null) {
				map.put(target - n, i+1);
			} else {
				res[0] = index;
				res[1] = i+1;
				break;
			}
		}

		return res;
	}
}
