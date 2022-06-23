class Solution {
    int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    
    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        
        //-----------------OPTIMIZATIONS------------
        int[] wordCharFreq = new int['z'-'A'+1]; //A-Z and a-z
        int[] boardCharFreq = new int['z'-'A'+1];
        
        for(char c : word.toCharArray())
            wordCharFreq[c - 'A']++;
        
        for(int r = 0; r < m; r++)
            for(int c = 0; c < n; c++)
                boardCharFreq[board[r][c] - 'A']++;
        
        //check board has enough character occurances
        for(char c : word.toCharArray())
            if(boardCharFreq[c - 'A'] < wordCharFreq[c - 'A'])
                return false;
        
        //making more options at leaf level in te recursion tree
        //if first char's frequency in our board is more than last char's then swapping the word
        if(boardCharFreq[word.charAt(0) - 'A'] > boardCharFreq[word.charAt(word.length()-1) - 'A']){
            StringBuilder revWord = new StringBuilder(word);
            revWord.reverse();
            word = revWord.toString();
        }
            
        //------------------------------------------
        
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