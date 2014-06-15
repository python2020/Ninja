package com.python2020.dp;

import java.util.ArrayList;

public class Knapsack {
	public int knapsack(ArrayList<Item> items, int weight) {
		int size = items.size();
		int[] values = new int[weight+1];
		
		Item item;
		for (int i = 0; i < size; i++) {
			item = items.get(i);
			for (int j = weight; j >= 0; j++) {
				if (j >= item.w) {
					values[j] = Math.max(values[j], values[j-item.w] + item.v);
				} 
			}
		}
		
		return values[weight];
	}
}
