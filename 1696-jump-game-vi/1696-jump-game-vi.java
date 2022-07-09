class Solution {
    public int maxResult(int[] nums, int k) {
        int n = nums.length;
       
        //holds max value idx at front and min at last
        Deque<Integer> dq = new ArrayDeque<>();
        
        dq.offerLast(0);
        
        for(int i=1;i<n;i++){
            //add maximum value at the starting of deque to nums[i]
            nums[i] += nums[dq.peekFirst()];
            
            //if current value is greater than minimum in queue then remove last values from queue
            while(dq.size()>0 && nums[i]>=nums[dq.peekLast()]) {
                dq.pollLast();
            }
            
            //add current value to queue
            dq.addLast(i);
            
            //if front value is beyond k members from i the remove front value
            if(i-dq.peekFirst()>=k) {
                dq.pollFirst();
            }
        }
        
        //answer is stored at last value
        return nums[n-1];
    }
}