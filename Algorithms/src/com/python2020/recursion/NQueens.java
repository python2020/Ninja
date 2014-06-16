package com.python2020.recursion;

import java.util.ArrayList;


public class NQueens {
	public boolean isAvailable(int curRow, int curCol, int[] cols) {
		int rowDist = 0, colDist = 0;
		for (int row = 0; row < curRow; row++) {
			rowDist = curRow - row;
			colDist = Math.abs(cols[row] - curCol);
			if (colDist == 0 || rowDist == colDist) return false; // Vertical and diagonal!!
		}
		return true;
	}
	
	public void solveNQueens(int row, int[] cols, ArrayList<String[]> results) {
		if (row == cols.length) { // A valid solution
	    	String[] config = new String[cols.length];
	    	StringBuffer rowConfig = null;
	    	for (int r = 0; r < cols.length; r++) {
	    		rowConfig = new StringBuffer();
	    		for (int col = 0; col < cols.length; col++) {
	    			if (col == cols[r]) rowConfig.append("Q");
	    			else rowConfig.append(".");
	    		}
	    		config[r] = rowConfig.toString();
	    	}
	    	results.add(config);	    	
	    } else {
	    	for (int col = 0; col < cols.length; col++) { // Try every column position
	    		if (isAvailable(row, col, cols)) {
	    			cols[row] = col;
	    			solveNQueens(row+1, cols, results); // Placing the queens row by row 
	    			//cols[row] = -1; // Backtracking
	    		}
	    	}
	   	}
	}
	
	// I
	public ArrayList<String[]> solveNQueens(int n) {
		ArrayList<String[]> results = new ArrayList<String[]>();
		int[] cols = new int[n];
		solveNQueens(0, cols, results);
		return results;
	}
	
	// Set column number for each row
	public void totalNQueens(int row, int[] cols, int[] total) {
		if (row == cols.length) {
			total[0] += 1;
	    } else {
	    	for (int col = 0; col < cols.length; col++) {
	    		if (isAvailable(row, col, cols)) {
	    			cols[row] = col;
	    			totalNQueens(row+1, cols, total);
	    			//cols[row] = -1;
	    		}
	    	}
	   	}
	}
	
	// II
    public int totalNQueens(int n) {
		int[] cols = new int[n];
		int[] total = new int[1];
		total[0] = 0; // Number of distinct solutions
		totalNQueens(0, cols, total);
		return total[0];
    }
	
	public static void main(String[] args) {
		NQueens x = new NQueens();
		int n = 8;
		System.out.println(x.totalNQueens(n));
		
		
		ArrayList<String[]> results = x.solveNQueens(n);
		String[] config = null;
    	for (int i = 0; i < results.size(); i++) {
    		config = results.get(i);
    		for (int j = 0; j < config.length; j++)
    			System.out.println(config[j]);
    		System.out.println();
    	}
    	System.out.println("\n");
	}
}
