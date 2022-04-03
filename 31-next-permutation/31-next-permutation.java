/////////////////////////////////// ALGORITHM //////////////////////////////////////////////////

// 1. find point i, where, a[i]<a[i+1]; while traversing from nums.length-2 -> 0
// 2. find point j, where, a[j]>a[i]; while traversing from nums.length-1 -> 0
// 3. swap(nums[i], nums[j]);
// 4. reverse(nums[i+1], end of nums)

////// Edge Case: if no i is found i.e. arr is like : 5, 4, 3, 2, 1 => JUST SKIP STEPS 1, 2, 3

class Solution {
    public void nextPermutation(int[] nums) {  
        //arr only has 1 or less characters
        if(nums == null || nums.length<=1) return;
        
        //Step 1
        int i=nums.length-2;
        while(i>=0 && nums[i]>=nums[i+1]){
            i--;
        }
        
        //Edge case
        if(i >= 0){
            //Step 2
            int j=nums.length-1;
            while(j>=0 && nums[j]<=nums[i]){
                j--;
            }

            //Step 3
            swap(nums, i, j);
        }
        // NOTE: i=-1 means Edge Case has occurred where we skip steps 1,2,3 and reverse(arr, 0, arr.length-1)
        //Step 4
        reverse(nums, i+1, nums.length-1); 
    }
    
    //function to swap 2 values in array
    public void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    //function to reverse arr between a range
    public void reverse(int[] arr, int i, int j){
        while(i<j){
            swap(arr, i, j);
            i++;
            j--;
        }
    }
}