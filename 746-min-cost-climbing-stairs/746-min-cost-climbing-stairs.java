class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length + 1];
        Arrays.fill(dp, -1);
        return Math.min(memo(cost, 0, dp), memo(cost, 1, dp));
        // return Math.min(rec(cost, 0), rec(cost, 1));
    }
    
    private int rec(int[] cost, int idx) {
        if(idx == cost.length) {
            return 0;
        }
        
        //1 step
        int step1 = 0;
        if(idx+1 <= cost.length) {
            step1 += rec(cost, idx+1);
        }
        
        //2 steps
        int step2 = 0;
        if(idx+2 <= cost.length) {
            step2 += rec(cost, idx+2);
        }
        
        return cost[idx] + Math.min(step1, step2);
    }
    
    private int memo(int[] cost, int idx, int[] dp) {
        if(idx == cost.length) {
            return dp[idx] = 0;
        }
        
        if(dp[idx] != -1) {
            return dp[idx];
        }
        
        //1 step
        int step1 = 0;
        if(idx+1 <= cost.length) {
            step1 += memo(cost, idx+1, dp);
        }
        
        //2 steps
        int step2 = 0;
        if(idx+2 <= cost.length) {
            step2 += memo(cost, idx+2, dp);
        }
        
        return dp[idx] = cost[idx] + Math.min(step1, step2);
    }
}