class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] charIdx = new int[26];
        Arrays.fill(charIdx, -1);
        
        for(int i=s.length()-1; i>=0; i--) {
            char ch = s.charAt(i);
            
            if(charIdx[ch-'a'] == -1) {
                charIdx[ch-'a'] = i;
            }
        }
        
        List<Integer> list = new ArrayList<>();
        int maxIdx = 0, stIdx = -1;
        for(int i=0; i<s.length(); i++) {
            
            char c = s.charAt(i);
            
            if(charIdx[c - 'a'] > maxIdx) {
                maxIdx = charIdx[c - 'a'] ;
            }
            
            if(i == maxIdx) {
                list.add(maxIdx - stIdx);
                stIdx = maxIdx;
            }
        }
        
        return list;
    }
}