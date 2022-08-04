class Solution {
    public int dominantIndex(int[] nums) {
        int highest = Integer.MIN_VALUE;
        int secondHighest = Integer.MIN_VALUE;
        int idx = -1;
        
        for(int i=0; i<nums.length; i++) {
            int num = nums[i];
            if(num > highest) {
                idx = i;
                secondHighest = highest;
                highest = num;
            } else if(num > secondHighest) {
                secondHighest = num;
            }
        }
        
        if(secondHighest * 2 <= highest) {
            return idx;
        }
        return -1;
    }
}