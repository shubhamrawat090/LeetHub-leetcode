class Solution {
    //pair class for storing row and col values
    class Pair {
        int row;
        int col;
        
        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
    
    public int orangesRotting(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        
        //using bfs level wise or multiple bfs simultaneously
        Queue<Pair> q = new ArrayDeque<>();
        int[][] dir = {{-1,0}, {1,0}, {0,-1}, {0,1}};
        
        for(int r=0; r<n; r++) {
            for(int c=0; c<m; c++) {
                //if a rotten orange found, add it in the 1st level of our queue
                if(grid[r][c] == 2) {
                    q.add(new Pair(r, c));
                }
            }
        }
        
        int time = 0;
        while(q.size()!=0) {
            int size = q.size();
            while(size-- > 0) {
                //get our top node in queue
                Pair node = q.remove();
                //add it's children/connected nodes in 4 directions(up, down, left, right) in queue if it is safe to do so
                for(int i=0; i<4; i++) {
                    //get new row and col in 1 of the 4 directions
                    int nr = node.row + dir[i][0];
                    int nc = node.col + dir[i][1];
                    
                    //check if it is safe to add in queue
                    //also check if it is a fresh orange only then add to queue
                    if(nr>=0 && nr<n && nc>=0 && nc<m && grid[nr][nc] == 1) {
                        //make that orange rotten now
                        grid[nr][nc] = 2;
                        //add this rotten orange to queue to make other oranges rotten
                        q.add(new Pair(nr, nc));
                    } 
                }
            }
            //1 minute has passed now
            time++;
        }
        
        //check if there is any fresh orange left
        for(int r=0; r<n; r++) {
            for(int c=0; c<m; c++) {
                if(grid[r][c] == 1) {
                    return -1;
                }
            }
        }
        
        //we are taking lv1 as time = 1 minute i.e. we are taking 1-based idx & we need 0-based idx
        return (time == 0) ? 0: time - 1;
    }
}