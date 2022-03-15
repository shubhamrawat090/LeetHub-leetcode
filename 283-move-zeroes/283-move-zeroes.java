class Solution {
    public void moveZeroes(int[] nums) {
        int size = nums.length, count=0;
       //Count all zeroes
        for(int i=0; i<size; i++){
            if(nums[i]==0) count++;
        }
        
        //Move all non zero to left
        int nonZeroIdx = 0;
        for(int i=0; i<size; i++){
            if(nums[i]!=0){
                nums[nonZeroIdx]=nums[i];
                nonZeroIdx++;
            }
        }
        
        //Make all last remaining elements zero
        int zeroIdx = size-1;
        while(count>0){
            nums[zeroIdx] = 0;
            count--;
            zeroIdx--;
        }
    }

}