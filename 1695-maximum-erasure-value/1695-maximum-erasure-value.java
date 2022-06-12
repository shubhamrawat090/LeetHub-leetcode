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
                visited[nums[first]] = false;
                sum -= nums[first];
                first++;
            }
            
            maxSum = Math.max(maxSum, sum);
        }
        
        return maxSum;
    }
}