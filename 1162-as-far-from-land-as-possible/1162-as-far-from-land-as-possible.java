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
    
    public int maxDistance(int[][] grid) {
        int len = grid.length;
        boolean[][] vis = new boolean[len][len];
        
        ArrayDeque<Pair> queue = new ArrayDeque<>();
        int count = 0;//count no. of 0's or water cell
        
        for(int i=0; i<len; i++) {
            for(int j=0; j<len; j++) {
                if(grid[i][j] == 1) {
                    queue.add(new Pair(i, j, 0));
                } else {
                    count++;
                }
            }
        }
        
        if(count == 0) {
            return -1;//no water exists
        }
        
        int dist = -1;
        
        while(queue.size()>0) {
            //remove
            Pair rem = queue.remove();
            
            //mark*
            if(vis[rem.i][rem.j]) {
                continue;
            }
            vis[rem.i][rem.j] = true;
            
            //work
            dist = Math.max(dist, rem.level);
            
            //add*
            addN(rem.i+1, rem.j, rem.level+1, grid, vis, queue);
            addN(rem.i-1, rem.j, rem.level+1, grid, vis, queue);
            addN(rem.i, rem.j+1, rem.level+1, grid, vis, queue);
            addN(rem.i, rem.j-1, rem.level+1, grid, vis, queue);
        }
        
        return dist;
    }
    
    private void addN(int i, int j, int level, int[][] grid, boolean[][] vis, ArrayDeque<Pair> queue) {
        int len = grid.length;
        //out of bounds or land or already visited
        if(i<0 || j<0 || i>=len || j>=len || grid[i][j] == 1 || vis[i][j]) {
            return;
        }
        
        queue.add(new Pair(i, j, level));
    }
}