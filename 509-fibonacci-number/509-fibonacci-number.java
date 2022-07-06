class Solution {
    public int fib(int n) {
        // return rec(n);
        // int[] dp = new int[n+1];
        // Arrays.fill(dp, -1);
        // return memo(n, dp);
        
        // return tabulate(n, dp);
        
        return spaceOptimize(n);
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
    
    public int tabulate(int n, int[] dp) {
        for(int i=0; i<=n; i++) {
            if(i==0 || i==1) {
                dp[i] = i;
                continue;
            }
            
            dp[i] = dp[i-1] + dp[i-2];
        }
        
        return dp[n];
    }
    
    public int spaceOptimize(int n) {
        if(n == 0 || n == 1) {
            return n;
        }
        
        int first = 0, second = 1;
        for(int i=2; i<=n; i++) {
            int curr = first + second;
            first = second;
            second = curr;
        }
        
        return second;
    }
}