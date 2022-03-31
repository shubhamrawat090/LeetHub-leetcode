class Solution {
    public int[] twoSum(int[] numbers, int target) {
        //2 Pointer Approch USED
        //start and end pointer
        int left = 0, right = numbers.length-1;
        
        //traverse before the meet
        while(left<right){
            //sum of no. at start and end ptr
            int sum = numbers[left]+numbers[right];
            
            //return the indices(1-based indexing) of the pair, if found
            if(sum == target){
                return new int[]{left+1, right+1};
            }
            //sum < target means we have to increase our sum to meet target
            if(sum<target){
                //left pointer is increased to go to a higher value as arr is sorted
                left++;
            }
            //sum > target means we have to deccrease our sum to meet target
            else{
                //right pointer is deccreased to go to a lower value as arr is sorted
                right--;
            }
        }
        
        //no pair found
        return null;
    }
}