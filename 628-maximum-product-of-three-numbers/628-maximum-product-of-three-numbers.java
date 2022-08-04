class Solution {
    public int maximumProduct(int[] nums) {
        //min1 is the minimun, min2 is second minimum
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE; 
        //max1 is maximum after third, max2 is second maximum after third
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE;
        // highest value
        int third = Integer.MIN_VALUE;
        
        for(int num: nums) {
            //smaller value than lowest value found
            if(num < min1) {
                min2 = min1; //put min as second min
                min1 = num; //update lowest
            } 
            //smaller value than second lowest value found
            else if(num < min2) {
                min2 = num; //update second lowest
            }
            
            //bigger value than highest value found
            if(num > third) {
                max2 = max1; //put first max as second max
                max1 = third; //put max as first max
                third = num; //update highest
            } 
            //bigger value than first max found
            else if(num > max1) {
                max2 = max1; //put first max as second max
                max1 = num; //update first max
            }
            //bigger value than second max found
            else if(num > max2) {
                max2 = num; //update second max
            }
        }
        
        int prod1 = min1 * min2 * third;
        int prod2 = max1 * max2 * third;
        
        return prod1>prod2 ? prod1: prod2;
    }
}