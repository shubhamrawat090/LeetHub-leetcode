// traverse all the boundary cell and if there is 1 then make the cell and its connected component to -1 beacuse from these cells we can walk off to the boundary remaining cells of 1 after that are those from which we can't walk off

class Solution {
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        //find connected components of all boundaries and mark then -1
        for(int i=0,j=0;j<m;j++){
            if(grid[i][j]==1)
                dfs(grid,i,j);
        }
        
        for(int i=n-1,j=0;j<m;j++){
            if(grid[i][j]==1)
                dfs(grid,i,j);
        }
        
        for(int i=0,j=0;i<n;i++){
            if(grid[i][j]==1)
                dfs(grid,i,j);
        }
        
        for(int i=0,j=m-1;i<n;i++){
            if(grid[i][j]==1)
                dfs(grid,i,j);
        }
        
        int ans = 0;
        
        //whichever is 1 will be the ones not connected to boundary islands
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1)
                    ans++;
            }
        }
        
        return ans;
    }
    
    public void dfs(int[][] arr,int row,int col){
        if(row<0 || col<0 || row>=arr.length || col>=arr[0].length || arr[row][col]==0 || arr[row][col]==-1)
            return;
        arr[row][col]=-1;
        dfs(arr,row-1,col);
        dfs(arr,row,col-1);
        dfs(arr,row,col+1);
        dfs(arr,row+1,col);
    }
}