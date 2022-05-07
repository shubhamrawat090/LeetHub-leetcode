//Better: Using Stack
//Space: O(n) Time O(n)
class Solution {
    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        int[] min = new int[n];
        
        min[0] = nums[0];
        
        //filling min arr with Minimum(prev min[i-1], curr nums[i])
        for(int i=1; i<n; i++) {
            min[i] = Math.min(min[i-1], nums[i]);
        }
        
        Stack<Integer> st = new Stack<>();
        
        for(int j=n-1; j>=0; j--) {
            //min[j] signifies ith element
            //only if jth element > ith element
            if(nums[j] > min[j]) {
                //st.peek() signifies kth element
                //remove all kth elements from stack which are less than or equal to ith element
                while(!st.isEmpty() && st.peek()<=min[j]) {
                    st.pop();
                }
                
                //if the stack is not empty and there is a kth element < jth element, we have found 132 sequence
                if(!st.isEmpty() && st.peek()<nums[j]) {
                    return true;
                }
                
                //if not 132 sequence has been found yet, try for other j keeping this nums[j] as kth element
                st.push(nums[j]); 
            }
        }
        //no such 132 sequence found
        return false;
    }
}