package arrays;

public class Stock {

	// multiple transactions
	public int maxProfitMultiple(int[] prices) {
		int result = 0;
		for (int i = 1; i < prices.length; i++) {
			result += Math.max(0, prices[i] - prices[i-1]);
		}

		return result;
	}

	// single transaction
	public int maxProfitSingle(int[] prices) {
		if (prices.length < 2) return 0;

		int lowest = prices[0], highest = lowest, max = 0;

		int x;
		for (int i = 1; i < prices.length; i++) {
			x = prices[i];
			if (x < lowest) { 
				lowest = x;
				highest = x;
			} else if (x > highest) {
				highest = x;
				max = Math.max(max, highest - lowest);
			} 
		}

//		for (int i = 1; i < prices.length; i++) {
//			x = prices[x];
//			lowest = Math.min(lowest, x);
//			highest = Math.max(highest, x);
//			max = Math.max(max, highest - lowest);
//		}
		
		return max;
	}    
}
