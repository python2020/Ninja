package com.python2020.arrays;

public class Stock {
	
	// multiple transactions
    public int maxProfit(int[] prices) {
        int result = 0;
        for (int i = 1; i < prices.length; i++) {
            result += Math.max(0, prices[i] - prices[i-1]);
        }
        
        return result;
    }
}
