class Solution {
    public int consecutiveNumbersSum(int n) {
        int count = 0;
        
        //checking for all no. of values which add up to n
        for(int k=1; 2*n > k*(k-1); k++) {
            //which k value satisfies the condition
            int numerator = n - (k * (k-1) / 2);
            
            if(numerator % k == 0) {
                count++;
            }
        }
        
        return count;
    }
}