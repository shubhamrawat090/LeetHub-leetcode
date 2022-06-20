class Solution {
    class Pair{
        int i;
        int j;
        int time;
        
        Pair(int i, int j, int time) {
            this.i = i;
            this.j = j;
            this.time = time;
        }
    }
    
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        
        boolean[][] vis = new boolean[n][n];
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.time - b.time);
        pq.add(new Pair(0, 0, grid[0][0]));
        
        while(pq.size()>0) {
            //remove
            Pair rem = pq.remove();
            
            //mark*
            if(vis[rem.i][rem.j]) {
                //continue if already visited
                continue;
            }
            vis[rem.i][rem.j] = true;
            
            //work
            if(rem.i == n-1 && rem.j == n-1) {
                //if reached last block then return time elapsed till then
                return rem.time;
            }
            
            //add*
            //call in 4 directions
            addN(rem.i+1, rem.j, rem.time, vis, pq, grid);
            addN(rem.i-1, rem.j, rem.time, vis, pq, grid);
            addN(rem.i, rem.j-1, rem.time, vis, pq, grid);
            addN(rem.i, rem.j+1, rem.time, vis, pq, grid);
        }
        
        //cannot reach the last block
        return -1;
    }
    
    private void addN(int i, int j, int time, boolean[][] vis, PriorityQueue<Pair> pq, int[][] grid) {
        int n = grid.length;
        //if out of bounds or already visited then return and do nothing
        if(i<0 || j<0 || i>=n || j>=n || vis[i][j] == true) {
            return;
        }
        
        //add in priority queue
        pq.add(new Pair(i, j, Math.max(time, grid[i][j])));
    }
}