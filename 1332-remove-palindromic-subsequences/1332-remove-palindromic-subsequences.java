class Solution {
    public int removePalindromeSub(String s) {
        if(s.equals("")) {
            return 0;
        }
        
        StringBuilder reverse = new StringBuilder();
        
        for(int i=s.length()-1; i>=0; i--) {
            reverse.append(s.charAt(i));
        }
        
        if(reverse.toString().equals(s)) {
            return 1;
        }
        
        return 2;
    }
}