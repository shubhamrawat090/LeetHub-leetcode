class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp, -1);
        
        // int minCoins = memo(coins.length, coins, amount, dp);
        // return minCoins!=Integer.MAX_VALUE? minCoins: -1;
        
        //tabular
        int minCoins = tabular(coins.length, coins, amount, dp);
        return minCoins!=Integer.MAX_VALUE? minCoins: -1;
    }
    
    //tabular
    private int tabular(int n, int[] coins, int amount, int[] dp) {
        
        for(int a=0;  a<=amount; a++) {
            if(a == 0) {
                dp[a] = 0;
                continue;
            }

            int ans = Integer.MAX_VALUE;

            for(int coin: coins) {
                if(a - coin >= 0) {
                    int subAns = 0;
                    
                    subAns = dp[a - coin];

                    if(subAns != Integer.MAX_VALUE && subAns+1<ans) {
                        ans = subAns+1;
                    }
                }
            }

            dp[a] = ans;
        }
        
        return dp[amount];
    }
    
    //memoized
    private int memo(int n, int[] coins, int amount, int[] dp) {
        if(amount == 0) return dp[amount] = 0;
        
        int ans = Integer.MAX_VALUE;
        
        for(int coin: coins) {
            if(amount - coin >= 0) {
                int subAns = 0;
                if(dp[amount-coin] != -1) {
                    subAns = dp[amount-coin];
                }
                else {
                    subAns = memo(n, coins, amount - coin, dp);
                }
                
                if(subAns != Integer.MAX_VALUE && subAns+1<ans) {
                    ans = subAns+1;
                }
            }
        }
        
        return dp[amount] = ans;
    }
    
    //recursive
    private int rec(int n, int[] coins, int amount) {
        if(amount == 0) return 0;
        
        int ans = Integer.MAX_VALUE;
        
        for(int coin: coins) {
            if(amount - coin >= 0) {
                int subAns = 0;
                subAns = rec(n, coins, amount - coin);
                
                if(subAns != Integer.MAX_VALUE && subAns+1<ans) {
                    ans = subAns+1;
                }
            }
        }
        
        return ans;
    }
}