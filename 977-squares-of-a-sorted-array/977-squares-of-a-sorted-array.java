class Solution {
    public int[] sortedSquares(int[] nums) { 
        int[] ans = new int[nums.length];
        
        int start = 0, end = nums.length-1;
        int idx = nums.length-1;
        
        while(start<=end) {
            int startSq = nums[start]*nums[start];
            int endSq = nums[end]*nums[end];
            
            if(startSq > endSq) {
                ans[idx] = startSq;
                start++;
            } else {
                ans[idx] = endSq;
                end--;
            }
            
            idx--;
        }
        
        return ans;
    }
}