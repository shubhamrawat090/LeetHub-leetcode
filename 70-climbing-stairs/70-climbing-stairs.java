class Solution {
    public int climbStairs(int n) {
        // int[] dp = new int[n+1];
      // return memo(n, 0, dp);
        
        //tabular
//         for(int idx = n; idx>=0; idx--){
//             if(idx == n){
//                 dp[idx] = 1;
//                 continue;
//             }

//             int ans = 0;

//             if(idx+1<=n){
//                 ans += dp[idx+1];
//             }

//             if(idx+2<=n){
//                 ans += dp[idx+2];
//             }

//             dp[idx] = ans;
//         }
        
//         return dp[0];
        
        //space optimize
        int next1=1, next2=1;
        for(int idx = n-2; idx>=0; idx--){
            int curr = next1 + next2;
            next2 = next1;
            next1 = curr;
        }
        
        return next1;
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