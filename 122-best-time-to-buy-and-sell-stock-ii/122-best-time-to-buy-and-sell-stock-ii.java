class Solution {
    //flag = 0 -> buy
    //flag = 1 -> sell
    
    //recursive function => will give TLE
//     public int rec(int idx, int flag, int[] arr){
//         //if we buy at last and don't sell then our profit id -ve, 
//         //since we have to maximize our profit, we send 0 as it is the least positive profit
//         if(idx == arr.length) {
//             return 0;
//         }
        
//         if(flag == 0) {
//                                             //BUY
//             //buying at this point => arr[idx] is spent by us, therefore, -arr[idx]
//             //flag is changed to sell => 1
//             int buyHere = -arr[idx] + rec(idx+1, 1, arr);
//             //not buying at this point => 0 is spent by us, therefore, subtract nothing
//             //flag remains buy => 0
//             int notBuyHere = rec(idx+1, 0, arr);
//             //returning the maximum of both the scenarios
//             return Math.max(buyHere, notBuyHere);
//         } else {
//                                             //SELL
//             //selling at this point => arr[idx] is gained by us, therefore, +arr[idx]
//             //flag is changed to buy => 0
//             int sellHere = arr[idx] + rec(idx+1, 0, arr);
//             //not buying at this point => 0 is gained by us, therefore, add nothing
//             //flag remains sell => 1
//             int notSellHere = rec(idx+1, 1, arr);
//             //returning the maximum of both the scenarios
//             return Math.max(sellHere, notSellHere);
//         }
//     }
    
    //memoized function => using 2D DP => still gives TLE
    // int[][] dp;
//     public int memo(int idx, int flag, int[] arr){
//         //if we buy at last and don't sell then our profit id -ve, 
//         //since we have to maximize our profit, we send 0 as it is the least positive profit
//         if(idx == arr.length) {
//             return dp[idx][flag] = 0;
//         }
        
//         if(dp[idx][flag] != 0) {
//             return dp[idx][flag];
//         }
        
//         if(flag == 0) {
//                                             //BUY
//             //buying at this point => arr[idx] is spent by us, therefore, -arr[idx]
//             //flag is changed to sell => 1
//             int buyHere = -arr[idx] + memo(idx+1, 1, arr);
//             //not buying at this point => 0 is spent by us, therefore, subtract nothing
//             //flag remains buy => 0
//             int notBuyHere = memo(idx+1, 0, arr);
//             //returning the maximum of both the scenarios
//             return dp[idx][flag] = Math.max(buyHere, notBuyHere);
//         } else {
//                                             //SELL
//             //selling at this point => arr[idx] is gained by us, therefore, +arr[idx]
//             //flag is changed to buy => 0
//             int sellHere = arr[idx] + memo(idx+1, 0, arr);
//             //not buying at this point => 0 is gained by us, therefore, add nothing
//             //flag remains sell => 1
//             int notSellHere = memo(idx+1, 1, arr);
//             //returning the maximum of both the scenarios
//             return dp[idx][flag] = Math.max(sellHere, notSellHere);
//         }
//     }
    
//     public int tabulate(int[] arr, int n) {
//         for(int idx = n; idx >= 0; idx--) {
//             for(int flag = 0; flag < 2; flag ++) {
//                 if(idx == n) {
//                     dp[idx][flag] = 0;
//                     continue;
//                 }

//                 if(flag == 0) {//buy
//                     int buyHere = -arr[idx] + dp[idx+1][1];
//                     int notBuyHere = dp[idx+1][0];
//                     dp[idx][flag] = Math.max(buyHere, notBuyHere);
//                 } else {//sell
//                     int sellHere = arr[idx] + dp[idx+1][0];
//                     int notSellHere = dp[idx+1][1];
//                     dp[idx][flag] = Math.max(sellHere, notSellHere);
//                 }
//             }
//         }
        
//         return dp[0][0];
//     }
    
    public int spaceOptimized(int[] arr, int n) {
        int[] prev = new int[2];
        int[] curr = new int[2];
        for(int idx = n; idx >=0; idx--) {
            for(int flag = 0; flag < 2; flag++) {
                if(idx == n) {
                    curr[flag] = 0;
                    continue;
                }

                if(flag == 0) {//buy
                    int buyHere = -arr[idx] + prev[1];
                    int notBuyHere = prev[0];
                    curr[flag] = Math.max(buyHere, notBuyHere);
                } else {//sell
                    int sellHere = arr[idx] + prev[0];
                    int notSellHere = prev[1];
                    curr[flag] = Math.max(sellHere, notSellHere);
                }
            }
            
            prev = curr;
        }
        
        return prev[0];
    }
    
    //driver function
    public int maxProfit(int[] arr) {
        int n = arr.length;
        // return rec(0, 0, arr);//gives TLE
        // dp = new int[arr.length+1][2];
        // return memo(0, 0, arr); //still gives TLE
        
        //tabulation
        // return tabulate(arr, n);
        
        //space optimized
        return spaceOptimized(arr, n);
    }
}