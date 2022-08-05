class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int count = 0, prevCount = 0;
        int si = 0, ei = 0;
        
        while(ei<nums.length) {
            if(left <= nums[ei] && nums[ei] <= right) {
                prevCount = ei - si + 1;
                count += prevCount;
            } else if(nums[ei] < left) {
                count += prevCount;
            } else {
                si = ei + 1;
                prevCount = 0;
            }
            
            ei++;
        }
        
        return count;
    }
}