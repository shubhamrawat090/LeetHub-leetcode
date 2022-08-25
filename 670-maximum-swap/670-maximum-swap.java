class Solution {
    public int maximumSwap(int num) {
        // num = 0, or num = single digit number
        if(num == 0 || num%10 == num) {
            return num;
        }
        
        char[] digits = Integer.toString(num).toCharArray();
        
        int[] lastIdx = new int[10];
        for(int i=0; i<digits.length; i++) {
            lastIdx[digits[i] - '0'] = i;
        }
        
        for(int i=0; i<digits.length; i++) {
            int digit = digits[i] - '0';
            
            for(int j=9; j>digit; j--) {
                if(lastIdx[j] > i) {
                    char temp = digits[i];
                    digits[i] = digits[lastIdx[j]];
                    digits[lastIdx[j]] = temp;
                    
                    return Integer.valueOf(new String(digits));
                }
            }
        }
        
        return num;
    }
    
    private LinkedList<Integer> numToDigits(int num) {
        LinkedList<Integer> digits = new LinkedList<>();
        while(num > 0) {
            int rem = num%10;
            digits.addFirst(rem);
            
            num/=10;
        }
        
        return digits;
    }
    
    private int digitsToNum(LinkedList<Integer> digits) {
        int num = 0;
        for(int digit: digits) {
            num = num*10;
            num += digit;
        }
        
        return num;
    }
}