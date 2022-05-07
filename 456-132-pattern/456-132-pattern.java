// Using the given array itself as stack (bottom on the right end)
class Solution {
    public boolean find132pattern(int[] nums) {
        int kThElement = Integer.MIN_VALUE;
        int top = nums.length;
        for(int j=nums.length-1; j>=0; j--){
            if(nums[j]<kThElement) return true;
            
            else{
                while(top<nums.length && nums[j]>nums[top]) 
                    kThElement = nums[top++];
            }
            //push in stack
            nums[--top] = nums[j];
        }
        return false;
    }
}