class Solution {
    public int maxOperations(int[] nums, int k) {
        //sort array
        Arrays.sort(nums);
        //start and end pointers
        int i=0, j=nums.length-1;
        int count = 0; // count no. of steps
        //till start and end ptrs meet or cross each other
        while(i<j) {
            //if we get a sum of k then count a step and move start and end ptrs
            if(nums[i] + nums[j] == k) {
                count++;
                i++;
                j--;
            }
            //if sum > k, move the end ptr as we need a smaller value
            else if(nums[i] + nums[j] > k) {
                j--;
            }
            //if sum < k, move the start ptr as we need a bigger value
            else {
                i++;
            } 
        }
        
        return count;
    }
}