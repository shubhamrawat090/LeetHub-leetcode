class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        boolean[] visited = new boolean[10001];
        int first=0, second=0;
        int sum = 0, maxSum = 0;
        while(second<nums.length) {
            if(!visited[nums[second]]) {
                //unique element
                visited[nums[second]] = true;
                sum += nums[second];
                second++;
            } else {
                //non unique
                
                while(nums[first]!=nums[second]) {
                    visited[nums[first]] = false;//discard first value
                    sum -= nums[first];
                    first++;
                }
                
                first++;
                second++;
            }
            
            maxSum = Math.max(maxSum, sum);
        }
        
        return maxSum;
    }
}