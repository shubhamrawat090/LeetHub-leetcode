class Solution {
    public int maxProfit(int[] prices) {
        int ans = 0, minTillNow = prices[0];
        int n = prices.length;
        for(int i=1; i<n; i++) {
            if(prices[i] < minTillNow) {
                minTillNow = prices[i];
            }
            
            int profit = prices[i] - minTillNow;
            ans = Math.max(ans, profit);
        }
        return ans;
    }
}