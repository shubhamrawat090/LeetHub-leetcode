class Solution {
    public void moveZeroes(int[] nums) {
        int nonZero = 0;
        int i;
        for(i=0; i<nums.length; i++) {
            if(nums[i]!=0) {
                nums[nonZero] = nums[i];
                nonZero++;
            }
        }
        
        for(; nonZero<nums.length; nonZero++) {
            nums[nonZero] = 0;
        }
    }

}