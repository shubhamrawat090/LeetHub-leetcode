class Solution {
    int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[][] vis = new boolean[m][n];
        
        int maxArea = 0;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == 1 && !vis[i][j]) {
                    maxArea = Math.max(maxArea, areaDFS(grid, vis, i, j, m, n));
                }
            }
        }
        
        return maxArea;
    }
    
    private int areaDFS(int[][] grid, boolean[][] vis, int i, int j, int m, int n) {
        if(i<0 || i>=m || j<0 || j>=n || grid[i][j] == 0 || vis[i][j] == true) {
            return 0;
        }
        
        vis[i][j] = true;
        
        int elems = 1;
        
        for(int[] d: dir) {
            int newI = i + d[0];
            int newJ = j + d[1];
            
            elems += areaDFS(grid, vis, newI, newJ, m, n);
        }
        
        return elems;
    }
}