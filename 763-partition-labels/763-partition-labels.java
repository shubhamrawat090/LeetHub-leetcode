class Solution {
    public List<Integer> partitionLabels(String s) {
        HashMap<Character, Integer> charIdx = new HashMap<>();
        
        for(int i=s.length()-1; i>=0; i--) {
            char ch = s.charAt(i);
            
            if(!charIdx.containsKey(ch)) {
                charIdx.put(ch, i);
            }
        }
        
        List<Integer> list = new ArrayList<>();
        int maxIdx = 0, stIdx = -1;
        for(int i=0; i<s.length(); i++) {
            
            char c = s.charAt(i);
            
            if(charIdx.get(c) > maxIdx) {
                maxIdx = charIdx.get(c);
            }
            
            if(i == maxIdx) {
                list.add(maxIdx - stIdx);
                stIdx = maxIdx;
            }
        }
        
        return list;
    }
}