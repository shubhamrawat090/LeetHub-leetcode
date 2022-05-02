// We use two pointer approach to keep track of the swapping of elements at correct positions . We traverse our array from the end while we maintain our two pointers from the beginning index i.e 0 and 1 for even and odd respectively .
// We only move our i'th pointer when we know that the current position is infact fulfulling our requirements .

class Solution {
    public void swap(int[] nums , int i , int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public int[] sortArrayByParityII(int[] nums) {
        int even = 0;   //even pointer
        int odd = 1;    // odd pointer
        int i = nums.length-1;   // we traverse from end of list
        while(i >= 0){
            if(nums[i] % 2 == i % 2)    //only move our pointer if cur placement is satisfied
                i--;
            else{
                if(nums[i] % 2 == 0){
                    swap(nums,even,i);
                    even+=2;
                }
                else{
                    swap(nums,odd,i);
                    odd+=2;
                }
            }
        }
        return nums;
    }
}