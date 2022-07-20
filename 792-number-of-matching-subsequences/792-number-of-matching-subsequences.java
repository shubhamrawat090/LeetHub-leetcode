class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        int count = 0;
        
        //just store duplicate words and their count inside hashmap so that you won't have to check for it again
        HashMap<String, Integer> map = new HashMap<>();
        for(String word: words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        
        for(String word: map.keySet()) {
            if(checkSubseq(word, s) == true) {
                count += map.get(word);
            }
        }
        
        return count;
    }
    
    private boolean checkSubseq(String small, String big) {
        if(small.length() > big.length()) {
            return false;
        }
        
        if(small.length() == big.length()) {
            return small.equals(big);
        }
        
        int s = 0, b = 0;
        
        while(s < small.length() && b < big.length()) {
            if(small.charAt(s) == big.charAt(b)) {
                s++;
            }
            
            b++;
        }
        
        return s == small.length();
    }
}