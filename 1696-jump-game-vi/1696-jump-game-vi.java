class Solution {
    public int maxResult(int[] nums, int k) {
        int n = nums.length;
       
        //holds max value idx at front and min at last
        Deque<Integer> dq = new ArrayDeque<>();
        
        dq.offerLast(0);
        
        for(int i=1;i<n;i++){
            nums[i] += nums[dq.peekFirst()];
            
            while(dq.size()>0 && nums[i]>=nums[dq.peekLast()]) {
                dq.pollLast();
            }
            
            dq.addLast(i);
            
            if(i-dq.peekFirst()>=k) {
                dq.pollFirst();
            }
        }
        
        return nums[n-1];
    }
}