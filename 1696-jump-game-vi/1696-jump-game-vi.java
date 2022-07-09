class Solution {
    public int maxResult(int[] nums, int k) {
         /**
        For every index starting from 1: --- n 
            Find out the max sum from all { i -1 } to  { i –k } index -- klogk
            sum[index] = value[index] + maxfound
        Result is sum[length -1]

        */
        
        int n = nums.length;
        int max = nums[0];
        
        // index --- maxSum
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> b[1]-a[1]);
        
        pq.offer(new int[]{0,nums[0]});
        
        for(int i=1;i<n;i++){
            
            while(i-pq.peek()[0]>k){
                pq.poll();
            }
            
            int[] top = pq.peek();
            
            max = nums[i] + top[1];
            
            pq.offer(new int[]{i,max});
            
        }
        
        return max;
    }
}