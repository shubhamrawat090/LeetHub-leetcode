// Iterate the nums array, find the first occurance that the nums[i] < max, then mark the starting index = i - 1 and end index = i. If nums[i] < max happens again, extend the end index. If nums[start -1] > nums[end], we need to decrease the starting index to find the real starting point. The starting point decreases at most n times. O(2n) is O(n).

class Solution {
    public int findUnsortedSubarray(int[] nums) {
        Integer start = null;
        Integer end = null;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= max) {
                max = nums[i];
            } else {
                if (start == null) {
                    start = i - 1;
                    end = i;
                } else {
                    end = i;
                }
                while (start > 0 && nums[end] < nums[start - 1]) start--;
            }
        }
        return start == null ? 0 : end - start + 1; 
    }
}