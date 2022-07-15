class Solution {    
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        
        int maxArea = 0;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == 1) {
                    maxArea = Math.max(maxArea, areaDFS(grid, i, j, m, n));
                }
            }
        }
        
        return maxArea;
    }
    
    private int areaDFS(int[][] grid, int i, int j, int m, int n) {
        if(i<0 || i>=m || j<0 || j>=n || grid[i][j] == 0 || grid[i][j] == -1) {
            return 0;
        }
        
        grid[i][j] = -1;
        
        return 1 + areaDFS(grid, i+1, j, m, n) + areaDFS(grid, i-1, j, m, n) + areaDFS(grid, i, j+1, m, n) + areaDFS(grid, i, j-1, m, n);
    }
}