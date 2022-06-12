class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int first=0, second=0;
        int sum = 0, maxSum = 0;
        while(second<nums.length) {
            if(set.add(nums[second])) {
                //unique element
                sum += nums[second];
                second++;
            } else {
                //non unique
                set.remove(nums[first]);
                sum -= nums[first];
                first++;
            }
            
            maxSum = Math.max(maxSum, sum);
        }
        
        return maxSum;
    }
}