class Solution {
    public int removePalindromeSub(String s) {
        StringBuilder sb = new StringBuilder(s);  
        return sb.reverse().toString().equals(s)? 1: 2;
    }
}