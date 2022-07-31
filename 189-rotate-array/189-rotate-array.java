class Solution {
    public void rotate(int[] nums, int k) {
        if(k < 0) {
            k += nums.length;
        }
        
        k = k % nums.length;
        
        rev(nums, 0, nums.length-k-1);
        rev(nums, nums.length-k, nums.length-1);
        rev(nums, 0, nums.length-1);
    }
    
    private void rev(int[] arr, int st, int ed) {
        while(st < ed) {
            int temp = arr[st];
            
            arr[st] = arr[ed];
            arr[ed] = temp;
            
            st++;
            ed--;
        }
    }
}