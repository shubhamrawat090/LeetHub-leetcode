class Solution {
    public int fib(int n) {
        // return rec(n);
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return memo(n, dp);
    }
    
    public int rec(int n) {
        if(n==0 || n==1)
            return n;
        
        return fib(n-1) + fib(n-2);
    } 
    
    public int memo(int n, int[] dp) {
        if(n==0 || n==1)
            return dp[n] = n;
        
        if(dp[n] != -1) {
            return dp[n];
        }
        
        return dp[n] = memo(n-1, dp) + memo(n-2, dp);
    } 
}