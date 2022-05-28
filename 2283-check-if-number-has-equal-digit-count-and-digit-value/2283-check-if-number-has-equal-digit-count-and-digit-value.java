class Solution {
    public boolean digitCount(String num) {
        int n = num.length();
        
        HashMap<Integer, Integer> map = new HashMap();
        
        for(int i=0; i<n; i++) {
            int digit = Character.getNumericValue(num.charAt(i));
            if(!map.containsKey(digit)) {
                map.put(digit, 1);
            } else {
                map.put(digit, map.get(digit)+1);
            }  
        }
        
        for(int i=0; i<n; i++) {
            if(!map.containsKey(i))
                map.put(i,0);
        }
        
        for(int key: map.keySet()) {
            int digit = Character.getNumericValue(num.charAt(key));
            int mapFreq = map.get(key);
            if(digit!=mapFreq) return false;
        }
        
        return true;
    }
}