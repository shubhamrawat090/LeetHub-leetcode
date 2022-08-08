class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE, currSum = 0;
        for(int i = 0; i<nums.length; ++i){
            currSum = Math.max(nums[i], currSum + nums[i]);
            maxSum = Math.max(currSum, maxSum);
        }
        return maxSum;
    }
}