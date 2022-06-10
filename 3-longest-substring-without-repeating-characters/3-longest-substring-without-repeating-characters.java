class Solution {
    public int lengthOfLongestSubstring(String s) {
        int first=0, second=0;
        int maxLen = 0;
        
        Set<Character> set = new HashSet<>();
        
        //work till second pointer has reached the end of the string
        while(second<s.length()) {
            //no duplicate
            if(set.add(s.charAt(second))) {
                //move second pointer
                second++;
                
                maxLen = Math.max(maxLen, set.size());
            } else {
                //remove char at first pointer from set
                set.remove(s.charAt(first));
                //move first pointer
                first++;
            }
        }
        
        return maxLen;
    }
}