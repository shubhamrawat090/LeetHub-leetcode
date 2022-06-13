class Solution {
    public int numIslands(char[][] grid) {
        int ans = 0;
        
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j] == '1') {
                   dfs(grid, i, j);
                    ans++;
                }
            }
        }
        
        return ans;
    }
    
    int[][] dir = {{0,-1}, {0,1}, {1,0}, {-1,0}};
    private void dfs(char[][] grid, int r, int c) {
        grid[r][c] = '2';
        for(int i=0; i<4; i++) {
            int nr = r+dir[i][0];
            int nc = c+dir[i][1];
            
            if(nr>=0 && nr<grid.length && nc>=0 && nc<grid[0].length && grid[nr][nc]=='1') {
                dfs(grid, nr, nc);
            }
        }
    }
}