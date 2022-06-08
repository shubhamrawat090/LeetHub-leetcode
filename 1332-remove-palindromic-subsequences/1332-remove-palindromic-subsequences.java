class Solution {
    public int removePalindromeSub(String s) {
        if(s.equals("")) {
            return 0;
        }
        
        StringBuilder sb = new StringBuilder(s);
        
        return sb.reverse().toString().equals(s)? 1: 2;
    }
}