class Solution {
    public int fib(int n) {
        int[] dp = new int[n+1];
        
        return tabulate(n, dp);
    }
    
    private int tabulate(int n, int[] dp) {
        for(int i=0; i<=n; i++) {
            if(i == 0 || i == 1) {
                dp[i] = i;
                continue;
            }

            int ans = dp[i-1] + dp[i-2];

            dp[i] = ans;
        }
        
        return dp[n];
    }
}