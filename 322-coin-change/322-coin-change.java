// Bottom-Up DP Tabulation
// Time: O(coins * amount), Space: O(amount)

class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp, amount+1);//fill with any val > amount
        dp[0] = 0; //as from 0 coins we can make 0 amount
        
        //iterate for each coin
        for(int coin: coins) {
            for(int i=coin; i<=amount; i++) {
                dp[i] = Math.min(dp[i], dp[i-coin]+1);
            }
        }
        
        //return -1 is dp[amount] is unchanged
        return dp[amount] <= amount ? dp[amount] : -1;
    }
}