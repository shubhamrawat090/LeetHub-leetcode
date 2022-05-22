class Solution {
    public int countSubstrings(String s) {
        int count=0;
        
        for(int i=0; i<s.length(); i++) {
           for(int j=i+1; j<=s.length(); j++) {
               String ss = s.substring(i,j);
               
               if(isPalindrome(ss)) count++;
           }
        }
        
        return count;
    }
    
    private boolean isPalindrome(String s) {
        int i=0, j=s.length()-1;
        
        while(i<j) {
            char ch1 = s.charAt(i);
            char ch2 = s.charAt(j);
            
            if(ch1!=ch2) return false;
            
            i++;
            j--;
        }
        
        return true;
    }
}