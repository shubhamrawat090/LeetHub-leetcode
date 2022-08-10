class Solution {
    public int fib(int n) {
        int[] dp = new int[n+1];
        
        Arrays.fill(dp, -1);
        
        return memo(n, dp);
    }
    
    private int memo(int n, int[] dp) {
        if(n == 0 || n == 1) {
            return dp[n] = n;
        }
        
        if(dp[n] != -1) {
            return dp[n];
        }
        
        int ans = memo(n-1, dp) + memo(n-2, dp);
        
        return dp[n] = ans;
    }
}