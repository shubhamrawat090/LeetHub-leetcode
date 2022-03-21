class Solution {
    public int reverse(int x) {
        int sign = x<0 ? -1: 1;
        
        x = Math.abs(x);
        
        int rev = 0;
        
        while(x!=0){
            //check if the result is outside the range of signed integer
            if(rev*sign > Integer.MAX_VALUE / 10 || rev*sign < Integer.MIN_VALUE / 10){
                // rev * multiplier * 10 might go out of range
                return 0;
            }
            
            int rem = x%10;
            rev=rev*10 + rem;
            
            // decreasing x by 1 digit
            x/=10;
        }
        
        return sign*rev;
    }
}