class Solution {
    public int minimumAverageDifference(int[] nums) {
        long sum = 0;
        long totalSum = 0;
        long min = Integer.MAX_VALUE;
        int n = nums.length;
        for(int i=0; i<n; i++){
            totalSum += nums[i];
        }
        int avgIdx = -1;
        
        for(int i=0; i<n; i++){
            sum += nums[i];
            long avg = sum/(i+1);
            
            totalSum -= nums[i];
            
            long avg2 = 0;
            if(i == n-1){
                avg2 = 0;
            }
            else {
                avg2 = totalSum/(n-i-1);
            }
            
            long absDiff = Math.abs(avg - avg2);
            if(absDiff < min){
                min = absDiff;
                avgIdx = i;
            }
            
        }
        
        return avgIdx;
    }
}