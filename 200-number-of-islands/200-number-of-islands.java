class Solution {
    public int numIslands(char[][] grid) {
        int ans = 0;
        
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j] == '1') {
                    dfs(grid, i, j);//dfs marks all current as well as its '1' neighbours visited
                    //counting all new connected components
                    ans++;
                }
            }
        }
        
        return ans;
    }
    
    private void dfs(char[][] grid, int r, int c) {
        //out of bounds or already visited
        if(r<0 || r>=grid.length || c<0 || c>=grid[0].length || grid[r][c]=='0') {
            return;
        }

        //mark visited
        grid[r][c] = '0';
        
        //call in all 4 directions
        dfs(grid, r+1, c);//down
        dfs(grid, r-1, c);//up
        dfs(grid, r, c+1);//right
        dfs(grid, r, c-1);//left
    }
}