class Solution {
    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        
        int l1 = num1.length(), l2 = num2.length();
        int[] res = new int[l1+l2]; // max length of the ans can be sum of digits of both numbers
        
        int carry = 0;
        int skipPlaces = 0;
        
        // traverse num2 from backwards JUST like we do in multiplication
        for(int i=l2-1; i>=0; i--) {
            carry = 0; //reset carry
            int n2 = num2.charAt(i) - '0'; //current digit of num2
            
            /* we fill res[] backwards but first we skip some spaces like depicted with "X"
                                       1 2 3
                                     * 4 5 6
                                   ----------
                                     1 3 6 8   10^0 => skip 0 places
                                     9 0 2 X   10^1 => skip 1 places
                                   4 5 6 X X   10^2 => skip 2 places
                                   ----------
                                   5 6 0 8 8
                                   ---------- 
           */
            int k = res.length-1 - skipPlaces;
            for(int j=l1-1; j>=0 || carry!=0; j--) {
                int n1 = j>=0 ? num1.charAt(j) - '0': 0;
                
                int product = (n1 * n2) + carry + res[k];
                
                carry = product/10;
                product = product%10;
                
                res[k--] = product;
            }
            
            skipPlaces++;
        }
        
        // remove leading zeroes and form the answer
        StringBuilder ans = new StringBuilder();
        boolean leadingZeroFlag = true;
        for(int i=0; i<res.length; i++) {
            if(res[i] == 0 && leadingZeroFlag == true) {
                // 0 encountered which is a LEADING one
                continue;
            } else {
                // first non zero encountered
                leadingZeroFlag = false;
                ans.append(res[i]);
            }
        }
        
        return new String(ans);
    }
    
    
}