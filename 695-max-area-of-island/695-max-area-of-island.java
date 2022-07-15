class Solution { 
    class Pair {
        int i;
        int j;
        
        Pair(int x, int y) {
            i = x;
            j = y;
        }
    }
    
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        
        int maxArea = 0;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == 1) {
                    maxArea = Math.max(maxArea, areaBFS(grid, i, j, m, n));
                }
            }
        }
        
        return maxArea;
    }
    
    private int areaBFS(int[][] grid, int i, int j, int m, int n) {
        Queue<Pair> q = new ArrayDeque<>();
        
        q.add(new Pair(i, j));
        
        int elems = 0;
        while(q.size() > 0) {
            //r m* w a*
            Pair rem = q.remove();
            
            if(grid[rem.i][rem.j] == 0 || grid[rem.i][rem.j] == -1) {
                continue;
            }
            
            grid[rem.i][rem.j] = -1;
            
            elems += 1;
            
            addN(grid, rem.i+1, rem.j, m, n, q);
            addN(grid, rem.i-1, rem.j, m, n, q);
            addN(grid, rem.i, rem.j+1, m, n, q);
            addN(grid, rem.i, rem.j-1, m, n, q);
        }
        
        return elems;
    }
    
    private void addN(int[][] grid, int i, int j, int m, int n, Queue<Pair> q) {
        if(i>=0 && i<m && j>=0 && j<n && grid[i][j] == 1) {
            q.add(new Pair(i, j));
        }
    }
}