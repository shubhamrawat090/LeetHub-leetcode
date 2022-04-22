class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int sum = nums[nums.length-1];
        
        for (int i = nums.length-2 ; i>= 0 ; i--) {
            sum += nums[i];
            
            if (nums[i] == 0 && nums[i+1] == 0) 
                return true;
            
           if (sum >= k || sum == 0) {
               int internalSum = nums[i];
               
               for (int j = i+1 ; j < nums.length ; j++) {
                    internalSum += nums[j];
                   
                   if (internalSum%k == 0) {
                       return true;
                   }
               }
           }     
        }
        
        return false;
    }
}