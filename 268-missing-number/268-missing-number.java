class Solution {
    // formula sum - sum of val in array = missing number
    public int missingNumber(int[] nums) {
        int sum = 0;
        for(int num: nums) {
            sum += num;
        }
        
        int n = nums.length;
        int formulaSum = n*(n+1)/2;
        
        return formulaSum - sum;
    }
}