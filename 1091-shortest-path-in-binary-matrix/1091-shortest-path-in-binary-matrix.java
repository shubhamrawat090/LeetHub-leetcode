class Solution {
    private class Pair {
        int row;
        int col;
        int path;
        
        Pair(int r, int c, int p) {
            row = r;
            col = c;
            path = p;
        }
    }
    
    public int shortestPathBinaryMatrix(int[][] grid) {
        //you cannot enter the grid
        if(grid[0][0] == 1) {
            return -1;
        }
        
        //Run BFS on paths where you can go then you will get the shortest path
        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(0,0,1));
        
        //All 8 direction calls
        int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
                 
        //Level wise BFS
        while(q.size()!=0) {
            int size = q.size();
            while(size-->0) {
                Pair rPair = q.remove();
                //if current block is the destination block then return the path calculated
                if(rPair.row == grid.length-1 && rPair.col == grid[0].length-1) {
                    return rPair.path;
                }
                
                //calling in all 8 directions
                for(int[] arr: dir) {
                    //next row, col to go to
                    int r = rPair.row + arr[0];
                    int c = rPair.col + arr[1];
                    
                    //if this next r,c is within the range of grid and you are allowed to go to this r,c
                    if(r>=0 && r<grid.length && c>=0 && c<grid[0].length && grid[r][c] == 0) {
                        q.add(new Pair(r,c,rPair.path+1));
                        grid[r][c] = 1;//mark this row as visited
                    }
                }
            }
        }
        //no minimum path found              
        return -1;
    }
}