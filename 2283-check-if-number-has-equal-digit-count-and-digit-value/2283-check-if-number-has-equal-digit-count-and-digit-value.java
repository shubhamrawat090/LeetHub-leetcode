//Frequency Array
class Solution {
    public boolean digitCount(String num) {
        //10 is the limit in constraints
        int[] freq = new int[10];
        
        //get freq of all digits
        for(int i=0; i<num.length(); i++) {
            freq[num.charAt(i)-'0']++;
        }
        
        //match it according to question
        for(int i=0; i<num.length(); i++) {
           if(freq[i]!=num.charAt(i)-'0')
               return false;
        }
        
        return true;
    }
}