class Solution {
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int[][][] dp = new int[51][51][51];
        
        //fill entire dp with -1
        for(int[][] d: dp) {
            for(int[] arr: d) {
                Arrays.fill(arr, -1);
            }
        }
        
        return memo(m, n, maxMove, startRow, startColumn, dp);
        // return rec(m, n, maxMove, startRow, startColumn);
        
    }
    
    // RECURSIVE
    public int rec(int m, int n, int maxMove, int startRow, int startColumn) {
        if(maxMove < 0) {
            return 0; //all allowed moves finished
        }
        
        if(startRow < 0 || startRow >= m  || startColumn < 0 || startColumn >= n) {
            return 1;//got outside 1 path
        }
        
        int moves = 0;
        int MOD = 1000000007;
        
        int up = rec(m, n, maxMove-1, startRow-1, startColumn);
        int down = rec(m, n, maxMove-1, startRow+1, startColumn);
        int left = rec(m, n, maxMove-1, startRow, startColumn-1);
        int right = rec(m, n, maxMove-1, startRow, startColumn+1);
        
        moves += (up % MOD) + (down % MOD) + (left % MOD) + (right % MOD);
        
        return moves % MOD;
    }
    
    // MEMOIZED
    public int memo(int m, int n, int maxMoves, int startRow, int startColumn, int[][][] dp) {
        if(maxMoves < 0) {
            return 0; //all allowed moves finished
        }
        
        if(startRow < 0 || startRow >= m  || startColumn < 0 || startColumn >= n) {
            return 1;
        }
        
        if(dp[startRow][startColumn][maxMoves] != -1) {
            return dp[startRow][startColumn][maxMoves];
        }
        
        long moves = 0;
        int MOD = 1000000007;
        
        long up = memo(m, n, maxMoves-1, startRow-1, startColumn, dp);
        long down = memo(m, n, maxMoves-1, startRow+1, startColumn, dp);
        long left = memo(m, n, maxMoves-1, startRow, startColumn-1, dp);
        long right = memo(m, n, maxMoves-1, startRow, startColumn+1, dp);
        
        moves += (up) + (down) + (left) + (right);
        
        return dp[startRow][startColumn][maxMoves] = (int)(moves % MOD);
    }
}