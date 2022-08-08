class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE, sum = 0;
        for(int num: nums){
            sum = Math.max(num, sum + num);
            maxSum = Math.max(sum, maxSum);
        }
        return maxSum;
    }
}