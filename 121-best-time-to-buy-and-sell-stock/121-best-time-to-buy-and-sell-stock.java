class Solution {
    
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    // Algorithm: 
    // - Iterate through the array keeping track of minimum so far
    // - At each step check if we can maximise our profit
    public int maxProfit(int[] prices) {
        int minSoFar = Integer.MAX_VALUE, maxProfit = 0;
        
        for(int i = 0; i < prices.length; i++) {      
            minSoFar = Math.min(minSoFar, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - minSoFar);
            
        }
        
        return maxProfit;
    }
}
