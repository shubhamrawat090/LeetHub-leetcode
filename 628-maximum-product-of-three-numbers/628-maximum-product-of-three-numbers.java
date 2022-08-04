class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        
        int firstThree = nums[0]*nums[1]*nums[nums.length-1];
        int lastThree = nums[nums.length-1]*nums[nums.length-2]*nums[nums.length-3];
        
        return firstThree > lastThree ? firstThree : lastThree;
    }
}