class Solution {
    int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    
    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(board[i][j] == word.charAt(0)) {
                    if(helper(i, j, m, n, board, word, 0) == true) {
                        return true;
                    }
                }
            }
        }
        
        return false;
    }
    
    private boolean helper(int r, int c, int m, int n, char[][] board, String word, int idx) {
        if(idx >= word.length()) {
            return true;
        }
        
        if(r<0 || r>=m || c<0 || c>=n || board[r][c] == '.') {
            return false;
        }
        
        if(board[r][c] != word.charAt(idx)) {
            return false;
        }
        
        board[r][c] = '.';
        
        boolean ans = false;
        
        for(int[] d: dir) {
            int nr = r + d[0];
            int nc = c + d[1];
            
            ans |= helper(nr, nc, m, n, board, word, idx+1);
        }
        
        board[r][c] = word.charAt(idx);
        
        return ans;
    }
}