class Solution {
    public int findUnsortedSubarray(int[] nums) {
        Integer start = null, end = null;
        int max = Integer.MIN_VALUE;
        
        for(int i=0; i<nums.length; i++) {
            if(nums[i] >= max) {
                max = nums[i];
            } else{
                if(start == null) {
                    start = i - 1;
                    end = i;
                }else {
                    end = i;
                }
                
                while(start > 0 && nums[start - 1] > nums[end]){
                    start--;
                }
            }
        }
        
        return start == null? 0: end - start + 1;
    }
}