class Solution {
    public int minMaxGame(int[] nums) {
        int flag = 0;
        int n = log2(nums.length), size = nums.length;
        while(n-->0) {
            for(int i=0; i<nums.length-1; i+=2) {
                if(flag == 0) {
                    nums[i/2] = Math.min(nums[i], nums[i+1]);
                    flag = 1;
                } else {
                    nums[i/2] = Math.max(nums[i], nums[i+1]);
                    flag = 0;
                }

                size /= 2;
            }
            flag = 0;
        }
        
        return nums[0];
    }
    
    public int log2(int N)
    {
 
        // calculate log2 N indirectly
        // using log() method
        int result = (int)(Math.log(N) / Math.log(2));
 
        return result;
    }
}