// Using the given array itself as stack
class Solution {
    public boolean find132pattern(int[] nums) {
        int kThElement = Integer.MIN_VALUE;
        int index = nums.length; //using nums itself as the stack (bottom on the right end)
        for(int j=nums.length-1; j>=0; j--){
            if(nums[j]<kThElement) return true;
            
            else{
                while(index<nums.length && nums[j]>nums[index]) 
                    kThElement = nums[index++];
            }
            //push in stack
            nums[--index] = nums[j];
        }
        return false;
    }
}