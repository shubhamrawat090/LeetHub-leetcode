class Solution {
    public int helper(int idx, int[] cost, int[] dp){
        if(idx == cost.length){
            return dp[idx] = 0;
        }
        
        if(dp[idx] != 0){
            return dp[idx];
        }
        
        int ans = cost[idx];
        
        int step1 = 0;
        
        if(idx+1<=cost.length){
            step1+=helper(idx+1, cost, dp);
        }
        
        int step2 = 0;
        
        if(idx+2<=cost.length){
            step2+=helper(idx+2, cost, dp);
        }
        
        return dp[idx] = ans + Math.min(step1, step2);
    }
    
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length + 1];
        int start0 = helper(0, cost, dp);
        int start1 = helper(1, cost, dp);
        
        return Math.min(start0, start1);
    }
}