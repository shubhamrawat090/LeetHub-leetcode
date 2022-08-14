class Solution {
    public int[][] largestLocal(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        int[][] ans = new int[rows-2][cols-2];
        
        for(int i=0; i<ans.length; i++) {
            for(int j=0; j<ans[0].length; j++) {
                int[] center = {i+1, j+1};
                
                int stRow = center[0]-1;
                int enRow = center[0]+1;
                int stCol = center[1]-1;
                int enCol = center[1]+1;
                
                int max = 1;
                for(int k = stRow; k<=enRow; k++) {
                    for(int l = stCol; l<=enCol; l++) {
                        max = Math.max(max, grid[k][l]);
                    }
                }
                
                ans[i][j] = max;
            }
        }
        
        return ans;
    }
}