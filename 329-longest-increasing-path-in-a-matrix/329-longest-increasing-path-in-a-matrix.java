class Solution {
    int[][] dir = {{0,1}, {0,-1}, {1,0}, {-1,0}};
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int longestPath = 0;
        int[][] dp = new int[m][n];
        
        //RECURSIVE
        //take all points in matrix as SOURCE and find all the paths and return the maximum from it
        // for(int i=0; i<m; i++) {
        //     for(int j=0; j<n; j++) {
        //         int path = dfs(matrix, m, n, i, j);
        //         longestPath = Math.max(longestPath, path);
        //     }
        // }
        
        //MEMOIZED
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                int path = memo(matrix, m, n, i, j, dp);
                longestPath = Math.max(longestPath, path);
            }
        }
        
        return longestPath;
    }
    
    //Recursive code: gives TLE
//     public int dfs(int[][] matrix, int m, int n, int r, int c) {
//         int maxPath = 0;
            
//         for(int[] d: dir) {
//             int newRow = r + d[0];
//             int newCol = c + d[1];
            
//             if(newRow>=0 && newRow<m && newCol>=0 && newCol<n && matrix[r][c]<matrix[newRow][newCol]) {
//                 maxPath = Math.max(maxPath, dfs(matrix, m, n, newRow, newCol));
//             }
//         }
        
//         return maxPath+1;
//     }
    
    //MEMOIZED
    public int memo(int[][] matrix, int m, int n, int r, int c, int[][] dp) {
        if(dp[r][c] != 0) {
            return dp[r][c];
        }
        
        int maxPath = 0;
            
        //call for all 4 directions
        for(int[] d: dir) {
            int newRow = r + d[0];
            int newCol = c + d[1];
            
            //if newRow, newCol is inside bounds of matrix and curr val < new val, then you can go
            if(newRow>=0 && newRow<m && newCol>=0 && newCol<n && matrix[r][c]<matrix[newRow][newCol]) {
                maxPath = Math.max(maxPath, memo(matrix, m, n, newRow, newCol, dp));
            }
        }
        
        //add current block(1) to it
        return dp[r][c] = maxPath+1;
    }
    
}