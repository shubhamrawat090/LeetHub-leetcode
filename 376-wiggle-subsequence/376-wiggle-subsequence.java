class Solution {
    public int wiggleMaxLength(int[] nums) {
        int ans = 1;
        int prevDiff = 0;
        
        for(int i=0; i<nums.length-1; i++){
            int diff = nums[i+1] - nums[i];
            if( (diff > 0 && prevDiff <= 0) || (diff < 0 && prevDiff >=0) ) {
                ans++;
                prevDiff = diff;
            }
        }
        
        return ans;
    }
}