class Solution {
    public int[] twoSum(int[] nums, int target) {
        int forwardCounter =1;
        while(forwardCounter < nums.length)
        {
            for(int i=0 ; (i + forwardCounter) < nums.length; i++)
            {
                if((nums[i] + nums[(i+forwardCounter)]) == target)
                    return new int[]{i,(i+forwardCounter)};
            }
            forwardCounter++;
        }
      return null;  
        
        
    
    }
}