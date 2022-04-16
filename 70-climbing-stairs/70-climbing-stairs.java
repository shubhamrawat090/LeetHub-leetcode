class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
      return memo(n, 0, dp);  
    }
    
    //memoized
    public int memo(int n, int idx, int[] dp){
        if(idx == n){
            return dp[idx] = 1;
        }
        
        if(dp[idx] != 0){
            return dp[idx];
        }
        
        int ans = 0;
        
        if(idx+1<=n){
            ans += memo(n, idx+1, dp);
        }
        
        if(idx+2<=n){
            ans += memo(n, idx+2, dp);
        }
        
        return dp[idx] = ans;
    }
    
    //recursive
    public int rec(int n, int idx){
        if(idx == n){
            return 1;
        }
        
        int ans = 0;
        
        if(idx+1<=n){
            ans += rec(n, idx+1);
        }
        
        if(idx+2<=n){
            ans += rec(n, idx+2);
        }
        
        return ans;
    }
}