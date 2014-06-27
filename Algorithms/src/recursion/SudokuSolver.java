package recursion;

public class SudokuSolver {
    public void solveSudoku(char[][] board) {
    	solveSudokuHelper(board, 0); // 1d for ease of recursion 

    }
    
    public boolean solveSudokuHelper(char[][] board, int position) { 	
    	if (position == 81) return true;
    	int row = position / 9, col = position % 9;
    	if (board[row][col] != '.') return solveSudokuHelper(board, position + 1);
    	
    	// Check row, column, 3x3 cell, falsify unavailable candidates
    	boolean[] candidates = new boolean[9];
    	char c;
    	for (int i = 0; i < 9; i++) candidates[i] = true; // Initialization
    	for (int i = 0; i < 9; i++) { 
    		c = board[row][i]; if (c != '.') candidates[c-'1'] = false;
    		c = board[i][col]; if (c != '.') candidates[c-'1'] = false;
    	}
    	
    	int cellRow = row / 3 * 3;
    	int cellCol = col / 3 * 3;
    	for (int i = 0; i < 3; i++)
	    	for (int j = 0; j < 3; j++) {
	    		c = board[cellRow + i][cellCol + j]; if (c != '.') candidates[c-'1'] =  false;
	    	}
    	
    	boolean result = false;
    	for (int i = 0; i < 9; i++) {
    		if (candidates[i]) {
    			board[row][col] = (char) (i + '1'); // Integer to char
    			if (solveSudokuHelper(board, position + 1)) return true;
    			board[row][col] = '.'; // Backtracking! DFS!!!
    		}
    	}
    	
		return result;
    }
    
    public void printBoard(char[][] board) {
    	for (int i = 0; i < 9; i++) {
    		for (int j = 0; j < 9; j++) {
    			System.out.print(board[i][j] + " ");
    		}
    		System.out.println();
    	}    	
		System.out.println();
    }
    
    public static void main(String[] args) {
    	char[][] board = new char[9][9];
    	String[] strs = {"..9748...","7........",".2.1.9...","..7...24.",".64.1.59.",".98...3..","...8.3.2.","........6","...2759.."};
    	String str;
    	for (int i = 0; i < 9; i++) {
    		for (int j = 0; j < 9; j++) {
    			str = strs[i];
    			board[i][j] = str.charAt(j);
    			System.out.print(board[i][j] + " ");
    		}
    		System.out.println();
    	}
		System.out.println();
		System.out.println();
    	
		
    	SudokuSolver x = new SudokuSolver();
    	x.solveSudoku(board);
    	x.printBoard(board);

    }
}
