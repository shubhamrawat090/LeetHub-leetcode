class Solution {
    public int[] productExceptSelf(int[] nums) {
        int prodAllExceptZero = 1;
        int zeroCount = 0;
        //get product of all numbers and count of zeroes in array
        for(int num: nums) {
            if(num == 0) {
                zeroCount++;
            } else {
                prodAllExceptZero *= num;
            }
        }
        
        for(int i=0; i<nums.length; i++) {
            //if there are no zeroes in array
            if(zeroCount == 0) {
                nums[i] = prodAllExceptZero/nums[i];
            } 
            //if only 1 zero present
            else if(zeroCount == 1) {
                //zero is at current position
                if(nums[i] == 0) {
                    nums[i] = prodAllExceptZero;
                } else {
                    nums[i] = 0;
                }
            }
            //if more than 1 zero present
            else {
                nums[i] = 0;
            }
        }
        
        return nums;
    }
}