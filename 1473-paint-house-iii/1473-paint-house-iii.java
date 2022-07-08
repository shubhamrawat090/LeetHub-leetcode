class Solution {
    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        int[][][] dp = new int[101][21][101];
        for(int[][] d: dp) {
            for(int[] arr: d) {
                Arrays.fill(arr, -1);
            }
        }
        
        int ans = memo(0, 0, 0, houses, cost, m, n, target, dp);
        return (ans == Integer.MAX_VALUE/2)? -1: ans;
        
        // int ans = rec(0, 0, 0, houses, cost, m, n, target);
        // return (ans == Integer.MAX_VALUE/2)? -1: ans;
    }
    
    // MEMOIZED
    private int memo(int idx, int prevHouseColor, int neighbors, int[] houses, int[][] cost, int m, int n, int target, int[][][] dp) {
        //neighbors exceeded given target
        if(neighbors>target) {
            return dp[idx][prevHouseColor][neighbors] = Integer.MAX_VALUE/2;
        }
        
        //all houses traversed
        if(idx == m) {
            //neighbors calculated is same as the target given
            if(neighbors == target) {
                return dp[idx][prevHouseColor][neighbors] = 0;//all neighbors reached and 0 cost is return as no house is left to paint
            } 
            //neighbors exceeding target
            else {
                return dp[idx][prevHouseColor][neighbors] = Integer.MAX_VALUE/2;
            }
        }
        
        if(dp[idx][prevHouseColor][neighbors] != -1) {
            return dp[idx][prevHouseColor][neighbors];
        }
        
        int ans = Integer.MAX_VALUE/2;
        //if house is not coloured
        if(houses[idx] == 0) {
            //traverse from all color options
            for(int color = 0; color<n; color++) {
                ans = Math.min(ans, cost[idx][color] + memo(idx+1, color+1, (prevHouseColor == color+1)? neighbors: neighbors+1, houses, cost, m, n, target, dp));
            }
        }
        //house is already colored
        else {
            ans = Math.min(ans, memo(idx+1, houses[idx], (houses[idx] == prevHouseColor)? neighbors: neighbors+1, houses, cost, m, n, target, dp));
        }
        
        return dp[idx][prevHouseColor][neighbors] = ans;
    }
    
    // RECURSIVE
    private int rec(int idx, int prevHouseColor, int neighbors, int[] houses, int[][] cost, int m, int n, int target) {
        //neighbors exceeded given target
        if(neighbors>target) {
            return Integer.MAX_VALUE/2;
        }
        
        //all houses traversed
        if(idx == m) {
            //neighbors calculated is same as the target given
            if(neighbors == target) {
                return 0;//all neighbors reached and 0 cost is return as no house is left to paint
            } 
            //neighbors exceeding target
            else {
                return Integer.MAX_VALUE/2;
            }
        }
        
        int ans = Integer.MAX_VALUE/2;
        //if house is not coloured
        if(houses[idx] == 0) {
            //traverse from all color options
            for(int color = 0; color<n; color++) {
                ans = Math.min(ans, cost[idx][color] + rec(idx+1, color+1, (prevHouseColor == color+1)? neighbors: neighbors+1, houses, cost, m, n, target));
            }
        }
        //house is already colored
        else {
            ans = Math.min(ans, rec(idx+1, houses[idx], (houses[idx] == prevHouseColor)? neighbors: neighbors+1, houses, cost, m, n, target));
        }
        
        return ans;
    }
}