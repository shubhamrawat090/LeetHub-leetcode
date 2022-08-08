// Using 2 pointer method
class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int evenPtr = 0, oddPtr = nums.length-1;
        
        while(evenPtr < oddPtr) {
            while(nums[evenPtr] % 2 == 0 && evenPtr < oddPtr) {
                evenPtr++;
            }
            
            while(nums[oddPtr] % 2 != 0 && evenPtr < oddPtr) {
                oddPtr--;
            }
            
            if(evenPtr < oddPtr) {
                swap(nums, evenPtr, oddPtr);
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