class Solution {
    class Pair {
        int i;
        int j;
        int level;
        
        Pair(int i, int j, int level) {
            this.i = i;
            this.j = j;
            this.level = level;
        }
    }
    
    public int[][] updateMatrix(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        boolean[][] vis = new boolean[m][n];
        
        ArrayDeque<Pair> queue = new ArrayDeque<>();
        
        //add all 0's with level = 0
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == 0) {
                    queue.add(new Pair(i, j, 0));
                }
            }
        }
        
        int[][] ans = new int[m][n];
        
        while(queue.size()>0) {
            //remove
            Pair rem = queue.remove();
            
            //mark*
            if(vis[rem.i][rem.j]) {
                continue;
            }
            vis[rem.i][rem.j] = true;
            
            //work
            ans[rem.i][rem.j] = rem.level;
            
            //add*
            addN(rem.i+1, rem.j, rem.level+1, grid, vis, queue);
            addN(rem.i-1, rem.j, rem.level+1, grid, vis, queue);
            addN(rem.i, rem.j+1, rem.level+1, grid, vis, queue);
            addN(rem.i, rem.j-1, rem.level+1, grid, vis, queue);
        }
        
        return ans;
    }
    
    private void addN(int i, int j, int level, int[][] grid, boolean[][] vis, ArrayDeque<Pair> queue) {
        int m = grid.length;
        int n = grid[0].length;
        
        //out of bounds or 0 or already visited
        if(i<0 || j<0 || i>=m || j>=n || grid[i][j] == 0 || vis[i][j]) {
            return;
        }
        
        queue.add(new Pair(i, j, level));
    }
}