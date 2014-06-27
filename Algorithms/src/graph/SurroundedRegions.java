package graph;

import java.util.LinkedList;
import java.util.Queue;


public class SurroundedRegions {    
    public void print(char[][] board) {
    	for (int i = 0; i < board.length; i++) {
    		for (int j = 0; j < board[0].length; j++) {
    			System.out.print(board[i][j]);
    		}
    		System.out.println();
    	}
    	System.out.println();
    }
    

    public void solve(char[][] board) {
        if(board == null || board.length == 0) return;
        int m = board.length, n = board[0].length;
        for(int i = 0; i < n; i++) {algo(0, i, board); algo(m - 1, i, board);}  // top and bottom rows
        for(int j = 1; j < m; j++) {algo(j, 0, board); algo(j, n - 1, board);} // left and right columns
        for(int i = 0; i < m; i++)
            for(int j = 0; j < n; j++)
                if(board[i][j] == 'O') board[i][j] = 'X';
                else if(board[i][j] == 'K') board[i][j] = 'O';
    }

    public void algo(int i, int j, char[][] board) {
        bfs(i, j, board);
    }
    
    public void bfs(int i, int j, char[][] board){
        Queue<Integer> queue = new LinkedList<Integer>(); // Store indexes in queue
        visit(i, j, queue, board);
        
        int cur, row, col;
        while (!queue.isEmpty()) {
            cur = queue.remove();
            row = cur / board[0].length;
            col = cur % board[0].length;
            visit(row-1, col, queue, board); // Up
            visit(row, col-1, queue, board); // Left
            visit(row+1, col, queue, board); // Down
            visit(row, col+1, queue, board); // Right
        }
    }
    
    public void visit(int i, int j, Queue<Integer> queue, char[][] board) {
        int m = board.length, n = board[0].length;
        if (i >= 0 && i < m && j >= 0 && j < n && board[i][j] == 'O') {
        	board[i][j] = 'K'; // "Keep"
        	queue.add(i * n + j); // 2-d => 1-d 
        }
    }

    public void dfs(int row, int col, char[][] board) {
    	int m = board.length, n = board[0].length;
    	if (row >= 0 && row < m && col >= 0 && col < n && board[row][col] == 'O') board[row][col] = 'K';
    	else return;
    	dfs(row-1, col, board); // Up
    	dfs(row, col-1, board); // Left
    	dfs(row+1, col, board); // Down
    	dfs(row, col+1, board); // Right
    }
    
    public static void main(String[] args) {
    	SurroundedRegions x = new SurroundedRegions();
    	char[][] board = {{'O', 'O', 'O'},{'O', 'X', 'X'},{'X', 'O', 'X'},{'O', 'X', 'O'},{'O', 'O', 'O'},{'O', 'X', 'O'}};
    		/*
    		{
    			{'O', 'O', 'O','X', 'O', 'O','O', 'O', 'O','X', 'O', 'O'},
    			{'O', 'O', 'X', 'O', 'X', 'O','O', 'O', 'O','X', 'O', 'O'},
    			{'O', 'O', 'O', 'X', 'O', 'O','O', 'O', 'O','X', 'O', 'O'}
    	};*/
    	x.print(board);
    	x.solve(board);
    	x.print(board);
    }
}



