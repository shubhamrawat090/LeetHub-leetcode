class Solution {
    public int minimumAverageDifference(int[] nums) {
        long sum = 0;
        int lC = 0;
        int rC = nums.length;
        long lSum = 0;
        
        long lA, rA;
        long minAverage = 1_000_000;
        long diff;
        int result = 0;
        
        for (int num : nums)
            sum += num;
        
        for (int i = 0; i < nums.length; ++i){
            ++lC;
            --rC;
            
            lSum += nums[i];
            sum -= nums[i];
            
            lA = lSum/ lC;
            rA = rC == 0 ? 0 : sum / rC;
            diff = Math.abs(lA - rA);
            
            if (diff < minAverage){
                minAverage = diff;
                result = i;
            }
        }
        
        return result;
    }
}