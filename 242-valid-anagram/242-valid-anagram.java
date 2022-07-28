class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }
        
        HashMap<Character, Integer> sMap = new HashMap<>();
        for(char c: s.toCharArray()) {
            if(!sMap.containsKey(c)) {
                sMap.put(c, 1);
            } else {
                sMap.put(c, sMap.get(c) + 1);
            }
        }
        
        for(char c: t.toCharArray()) {
            if(!sMap.containsKey(c)) {
                return false;
            }
            
            if(sMap.containsKey(c)) {
                sMap.put(c, sMap.get(c)-1);
            }
        }
        
        for(char c: sMap.keySet()) {
            if(sMap.get(c) != 0) {
                return false;
            }
        }
        
        return true;
    }
}