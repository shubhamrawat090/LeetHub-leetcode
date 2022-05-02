class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        int[] even = new int[nums.length/2];
        int[] odd = new int[nums.length/2];
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
        e=0;
        o=0;
        for(int i=0; i<nums.length; i++) {
            if(i%2 == 0) {
                nums[i] = even[e];
                e++;
            }else {
                nums[i] = odd[o];
                o++;
            }
        }
        
        return nums;
    }
}