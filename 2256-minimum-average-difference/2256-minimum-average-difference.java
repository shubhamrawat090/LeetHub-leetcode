class Solution {
    public int minimumAverageDifference(int[] nums) {
        long rSum = 0;
        int lCtr = 0;
        int rCtr = nums.length;
        long lSum = 0;
        
        long lAvg, rAvg;
        long minAverage = 1_000_000;
        long diff;
        int minAvgIdx = 0;
        
        for (int num : nums)
            rSum += num;
        
        for (int i = 0; i < nums.length; ++i){
            ++lCtr;
            --rCtr;
            
            lSum += nums[i];
            rSum -= nums[i];
            
            lAvg = lSum/ lCtr;
            rAvg = rCtr == 0 ? 0 : rSum / rCtr;
            diff = Math.abs(lAvg - rAvg);
            
            if (diff < minAverage){
                minAverage = diff;
                minAvgIdx = i;
            }
        }
        
        return minAvgIdx;
    }
}