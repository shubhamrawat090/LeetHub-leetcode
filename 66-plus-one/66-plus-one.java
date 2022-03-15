class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 0;
        int size = digits.length;
        for(int i=size-1; i>=0; i--){
            int digit = (i==size-1)? (carry+digits[i]+1)%10 : (carry+digits[i])%10;
            carry = (i==size-1)? (carry+digits[i]+1)/10 : (carry+digits[i])/10;
            
            digits[i] = digit;
        }
        
        if(carry!=0){
            int[] resultant = new int[size+1];
            resultant[0] = carry;
            int i=1;
            for(int digit: digits){
                resultant[i] = digit;
            }
            
            return resultant;
        }
        
        return digits;
    }
}