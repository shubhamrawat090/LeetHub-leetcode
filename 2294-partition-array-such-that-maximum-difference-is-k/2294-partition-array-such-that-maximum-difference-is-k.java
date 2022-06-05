class Solution {
    public int partitionArray(int[] nums, int k) {
        //Arrays.sort(nums);
        int result = 0;
        boolean [] visited = new boolean [100_001];
        int prev = - k - 1;
        
        for (int num : nums){
            visited[num] = true;
        }
        
        for (int i = 0; i < visited.length; ++i){
            if (!visited[i]) continue;
            
            if (i - prev > k){
                ++result;
                prev = i;
            }
        }
        
        return result;
    }
}