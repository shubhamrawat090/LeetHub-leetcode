class Solution {
    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        
        int l1 = num1.length(), l2 = num2.length();
        int[] res = new int[l1+l2];
        
        int carry = 0;
        int skipPlaces = 0;
        
        for(int i=l2-1; i>=0; i--) {
            carry = 0;
            int n2 = num2.charAt(i) - '0';
            
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