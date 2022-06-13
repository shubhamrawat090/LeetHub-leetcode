class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        // return rec(triangle, 0, 0);
        int[][] dp = new int[200][200];
        for(int[] a: dp) {
            Arrays.fill(a, -1);
        }
        
        return memo(triangle, 0, 0, dp);
    }
    
    //MEMOIZED
    private int memo(List<List<Integer>> triangle, int r, int c, int[][] dp) {
        if(r==triangle.size() || c==triangle.get(r).size()) {
            return dp[r][c] = 0;
        }
        
        if(dp[r][c] != -1) {
            return dp[r][c];
        }
        
        int same = triangle.get(r).get(c);
        same += memo(triangle, r+1, c, dp);
        
        int next = triangle.get(r).get(c);
        next += memo(triangle, r+1, c+1, dp);
        
        return dp[r][c] = Math.min(same, next);
    }
    
    //RECURSIVE
    private int rec(List<List<Integer>> triangle, int r, int c) {
        if(r==triangle.size() || c==triangle.get(r).size()) {
            return 0;
        }
        
        int same = triangle.get(r).get(c);
        same += rec(triangle, r+1, c);
        
        int next = triangle.get(r).get(c);
        next += rec(triangle, r+1, c+1);
        
        return Math.min(same, next);
    }
    
}