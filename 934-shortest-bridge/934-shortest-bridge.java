class Solution {
    class Pair {
        int i;
        int j;
        int dist;
        
        Pair(int i, int j, int dist) {
            this.i = i;
            this.j = j;
            this.dist = dist;
        }
    }
    
    public int shortestBridge(int[][] grid) {
        int n = grid.length;
        
        boolean[][] vis = new boolean[grid.length][grid[0].length];
        boolean found = false;
        
        Queue<Pair> q = new ArrayDeque<>();
        
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    dfs(grid, i, j, q, vis);
                    found = true;
                }
                
                if(found == true) {
                    break;
                }
            }
            
            if(found == true) {
                break;
            }
        }
        
        boolean[][] vis2 = new boolean[grid.length][grid[0].length];
        
        while(q.size() > 0) {
            Pair rem = q.remove();
            
            if(vis2[rem.i][rem.j]) {
                continue;
            }
            vis2[rem.i][rem.j] = true;
            
            if(grid[rem.i][rem.j] == 1) {
                return rem.dist-1;
            }
            
            addN(grid, vis2, rem.i+1, rem.j, rem.dist+1, q);
            addN(grid, vis2, rem.i-1, rem.j, rem.dist+1, q);
            addN(grid, vis2, rem.i, rem.j+1, rem.dist+1, q);
            addN(grid, vis2, rem.i, rem.j-1, rem.dist+1, q);
        }
        
        return -1;
    }
    
    private void addN(int[][] grid, boolean[][] vis, int i, int j, int dist, Queue<Pair> q) {
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || vis[i][j] || grid[i][j] == 2) {
            return;
        }
        
        q.add(new Pair(i, j, dist));
    }
    
    private void dfs(int[][] grid, int i, int j, Queue<Pair> q, boolean[][] vis) {
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || vis[i][j] || grid[i][j] != 1) {
            return;
        }
        
        vis[i][j] = true;
        
        q.add(new Pair(i, j, 0));
        
        dfs(grid, i+1, j, q, vis);
        dfs(grid, i-1, j, q, vis);
        dfs(grid, i, j+1, q, vis);
        dfs(grid, i, j-1, q, vis);
        
        grid[i][j] = 2;
    }
}