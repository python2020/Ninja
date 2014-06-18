package com.python2020.recursion;

public class WordSearch {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) 
            for (int j = 0; j < n; j++)
                if (search(board, i, j, 0, word, visited)) 
                    return true;
        
        return false;   
    }
    
    public boolean search(char[][] board, int i, int j, int p, String word, boolean[][] visited) {
        if (p == word.length()) return true; // 1
        
        if (i < 0 || i == board.length || j < 0 || j == board[0].length || visited[i][j] || 
            board[i][j] != word.charAt(p)) return false; // 2
       
        visited[i][j] = true; // 3
        p++; // 4
        if (search(board, i+1, j, p, word, visited) || 
            search(board, i-1, j, p, word, visited) || 
            search(board, i, j+1, p, word, visited) || 
            search(board, i, j-1, p, word, visited)) return true;
        
        visited[i][j] = false; // 5
        return false;
    }
}
