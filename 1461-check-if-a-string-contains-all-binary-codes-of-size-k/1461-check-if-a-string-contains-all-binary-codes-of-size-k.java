class Solution {
    public boolean hasAllCodes(String s, int k) {
        HashSet<String> set = new HashSet();
        
        int st=0;
        while(st+k<=s.length()) {
            String num = s.substring(st, st+k);
            
            set.add(num);
            
            st++;
        }
        
        return set.size() == 1<<k;
    }
}