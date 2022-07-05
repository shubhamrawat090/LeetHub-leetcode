class Solution {
    public int longestConsecutive(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int i;
        int n = nums.length;
        
        // Corner cases
        if(n==0 || n==1) return n;
        
        // All elements are added & maintained in priority queue in ascending order
        for(i=0;i<n;i++){
            pq.offer(nums[i]);
        }
        
        // Intialize the answer to 0
        int maxLength = 0;
        int num1 = pq.poll();
        
        // Intialize the current length of sequence to 1 since num1 already polled/considered above
        int len = 1;
        
        // Until queue is empty, keep checking difference between adjacent elements
        while(pq.isEmpty() == false){
            int num2 = pq.poll();
            int diff = num2 - num1;
            
            // If difference is more than 1, then update maxLength and reset len to 1
            if(diff > 1){
                if(len > maxLength){
                    maxLength = len;
                }
                len = 1;
            }
            else if(diff == 0){
                // Do nothing if diff = 0 i.e. adjacent elements are same that's okay 
                // For instance, if nums = [1,2,3,4,4,5,6,7,8,9,10,11]
                // Then answer is 11(1 to 11 even though 4 is twice) 
                // & answer is not 8 (from 4 to 11)
            }
            else{
                // If diff = 1, then increment the length of current sequence
                len++;
            }
            
            // Update num1 for next iteration
            num1 = num2;
        }
        
        // Don't forget this condition, in case the whole pq elements are in sequence
        // then this condition must be written else maxLength will remain 0
        if(len > maxLength){
            maxLength = len;
        }
        
        return maxLength;
    }
}