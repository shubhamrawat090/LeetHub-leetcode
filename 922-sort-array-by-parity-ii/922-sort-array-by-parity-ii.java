class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        //even odd store separately in arrays
        int[] even = new int[nums.length/2];
        int[] odd = new int[nums.length/2];
        //even ptr and odd ptr 
        int e=0, o=0;
        for(int num: nums) {
            if(num%2 == 0) {
                even[e] = num;
                e++;
            }else {
                odd[o] = num;
                o++;
            }
        }
        //reset even and odd ptr
        e=0;
        o=0;
        //traverse the arr
        for(int i=0; i<nums.length; i++) {
            //if element is even then add value from even arr
            if(i%2 == 0) {
                nums[i] = even[e];
                e++;
            }
            //if element is odd then add value from odd arr
            else {
                nums[i] = odd[o];
                o++;
            }
        }
        
        return nums;
    }
}