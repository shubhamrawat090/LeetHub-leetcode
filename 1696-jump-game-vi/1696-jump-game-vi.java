class Solution {
    public int maxResult(int[] nums, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        
        pq.add(new int[]{0, nums[0]});
        
        int max = nums[0];
        for(int i=1; i<nums.length; i++) {
            while(i-pq.peek()[0]>k) {
                pq.remove();
            }
            
            int[] top = pq.peek();
            
            max = nums[i] + top[1];
            
            pq.add(new int[]{i, max});
        }
        
        return max;
    }
}