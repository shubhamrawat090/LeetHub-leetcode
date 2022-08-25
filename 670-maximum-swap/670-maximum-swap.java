class Solution {
    public int maximumSwap(int num) {
        // num = 0, or num = single digit number
        if(num == 0 || num%10 == num) {
            return num;
        }
        
        LinkedList<Integer> digits = numToDigits(num);
        
        int[] lastIdx = new int[10];
        for(int i=0; i<digits.size(); i++) {
            lastIdx[digits.get(i)] = i;
        }
        
        boolean swap = false;
        for(int i=0; i<digits.size(); i++) {
            int digit = digits.get(i);
            
            for(int j=9; j>digit; j--) {
                if(lastIdx[j] > i) {
                    int temp = digits.get(lastIdx[j]);
                    digits.set(lastIdx[j], digits.get(i));
                    digits.set(i, temp);
                    swap = true;
                    break;
                }
            }
            
            if(swap == true) break;
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