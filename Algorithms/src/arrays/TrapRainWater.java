package arrays;

public class TrapRainWater {
	public int trap(int[] A) {
		if (A.length == 0) return 0;

		int[] L = new int[A.length];
		int highest = A[0];
		for (int i = 1; i < A.length; i++) {
			L[i] = highest;
			highest = Math.max(A[i], highest);
		}

		int sum = 0;
		highest = A[A.length-1];
		for (int i = A.length-2; i >= 0; i--) {
			sum += Math.max(0, Math.min(highest, L[i]) - A[i]);
			highest = Math.max(A[i], highest);
		}

		return sum;
	}

	public static void main(String[] args) {
		TrapRainWater x = new TrapRainWater();
		int[] A = {2,0,2};
		System.out.println(x.trap(A));
	}
}
