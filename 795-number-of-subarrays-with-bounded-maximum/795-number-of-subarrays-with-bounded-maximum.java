class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int si = 0, ei = 0;
        int totalCount = 0, prevCount = 0;
        
        while(ei < nums.length) {
            int num = nums[ei];
            //within range
            if(left<=num && num<=right) {
                //get prev subArr count
                prevCount = ei - si + 1;
                //add prevCount to totalCount
                totalCount += prevCount;
            }
            
            //less than lowest
            else if(num < left) {
                //add prevCount to totalCount
                totalCount += prevCount;
            }
            
            //higher than highest
            else if(num > right) {
                //do reset
                
                //skip till ei
                si = ei + 1;
                // set prev sub arr count = 0 for next as this is BREAK POINT
                prevCount = 0;
            }
            
            ei++; // always increments by 1
        }
        
        return totalCount;
    }
}