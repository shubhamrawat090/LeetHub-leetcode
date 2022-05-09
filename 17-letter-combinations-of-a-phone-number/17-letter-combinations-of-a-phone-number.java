class Solution {
    public List<String> letterCombinations(String digits) {
        if(digits.isEmpty()) return new ArrayList<>();
        
        return helper("", digits);
    }
    
    public List<String> helper(String p, String up) {
        if(up.isEmpty()) {
            List<String> base = new ArrayList<>();
            base.add(p);
            return base;
        }
        
        int firstNum = up.charAt(0) - '0';
        
        int startIdx = (firstNum - 2) * 3, lastIdx = (firstNum - 1) * 3;
        
        if(firstNum == 7) {
            lastIdx++;
        }else if(firstNum == 8) {
            startIdx++;
            lastIdx++;
        }else if(firstNum == 9) {
            startIdx++;
            lastIdx+=2;
        }
        
        List<String> ans = new ArrayList<>();
        
        for(int i=startIdx; i<lastIdx && i<26; i++) {
            char ch = (char)('a' + i);
            
            ans.addAll(helper(p+ch, up.substring(1)));
        }
        
        return ans;
    }
}