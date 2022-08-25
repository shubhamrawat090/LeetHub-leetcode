class Solution {
    public int maximumSwap(int num) {
        // num = 0, or num = single digit number
        if(num == 0 || num%10 == num) {
            return num;
        }
        
        LinkedList<Integer> digits = numToDigits(num);
        
        for(int i=0; i<digits.size()-1; i++) {
            int digit = digits.get(i);
            if(digit != 9) {
                int max = digit;
                int maxIdx = i;
                for(int j=i+1; j<digits.size(); j++) {
                    if(digits.get(j) >= max) {
                        maxIdx = j;
                        max = digits.get(j);
                    }
                }
                
                if(max == digit) {
                    continue;
                } else {
                    digits.set(i, max);
                    digits.set(maxIdx, digit);
                    break;
                }
            }
        }
        
        return digitsToNum(digits);
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