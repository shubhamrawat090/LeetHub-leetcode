// Using 2 pointer method
class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int evenPtr = 0, oddPtr = nums.length-1;
        
        while(evenPtr < oddPtr) {
            // left side odd
            if(nums[evenPtr] % 2 != 0) {
                // right side even
                if(nums[oddPtr] % 2 == 0) {
                    swap(nums, evenPtr, oddPtr);
                    evenPtr++;
                    oddPtr--;
                }
                
                // right side odd
                else {
                    oddPtr--;
                }
            }
            
            // left side even
            else {
                evenPtr++;
            }
        }
        
        return nums;
    }
    
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}