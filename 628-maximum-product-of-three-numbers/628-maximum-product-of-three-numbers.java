class Solution {
    public int maximumProduct(int[] nums) {
        // lowest 2 num * highest vs highest 2 num * highest
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, highest = Integer.MIN_VALUE;
        
        for(int num: nums) {
            if(num < min2) {
                min1 = min2;
                min2 = num;
            } else if(num < min1) {
                min1 = num;
            }
            
            if(num > highest) {
                max1 = max2;
                max2 = highest;
                highest = num;
            } else if(num > max2) {
                max1 = max2;
                max2 = num;
            } else if(num > max1) {
                max1 = num;
            }
        }
        
        int prod1 = min1 * min2 * highest, prod2 = max1 * max2 * highest;
        
        return prod1 > prod2 ? prod1 : prod2;
    }
}