class Solution {
    int MOD = 1000000007;
    public int kConcatenationMaxSum(int[] arr, int k) {
        long sum1 = kadane(arr);
        
        if(k == 1) {
            return (int)(sum1);
        }
        
        int n = arr.length;
        int sumTotal = 0;
        int[] dArr = new int[2*n];
        
        for(int i=0; i<n; i++) {
            sumTotal += arr[i];
            
            dArr[i] = arr[i];
            dArr[i + n] = arr[i];
        }
        
        long sum2 = kadane(dArr);
        
        if(sumTotal > 0) {
            return (int)((sum2 + (k - 2l) * sumTotal) % MOD);
        } else {
            return (int)(sum2%MOD);
        }
    }
    
    public long kadane(int[] nums){
        long maxSum = 0, currSum = 0;
        for(int i = 0; i<nums.length; ++i){
            currSum = Math.max(nums[i], currSum + nums[i]);
            maxSum = Math.max(currSum, maxSum);
        }
        return maxSum;
    }
}