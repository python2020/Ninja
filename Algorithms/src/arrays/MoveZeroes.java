package arrays;

public class MoveZeroes {
	public void moveZeroes(int[] nums) {
		int i = 0;
		while (i < nums.length && nums[i] != 0) {
			i++;
		}

		int zeroStart = i;

		for (++i; i < nums.length; i++) {
			if (nums[i] != 0) {
				nums[zeroStart] = nums[i];
				nums[i] = 0;
				zeroStart++;
			}
		}
	}
}
