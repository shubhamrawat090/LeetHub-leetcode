class Solution {
    public boolean isPowerOfThree(int n) {
        if(n<=0) {
            return false;
        }
        
        //keep dividing by 3 and check at each step if it is a perfect integer and doesn't have decimal places
        while(n!=1) {
            double num = n/3.0;
            
            if(num != (int)num) {
                return false;
            }
                
            n /= 3;
        }
        
        return true;
    }
}