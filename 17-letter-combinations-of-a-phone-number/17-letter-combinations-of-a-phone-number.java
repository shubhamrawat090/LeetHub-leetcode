class Solution {
    public static String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    
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
        
        String values = map[firstNum];
        
        List<String> ans = new ArrayList<>();
        
        for(char val: values.toCharArray()) {
            ans.addAll(helper(p+val, up.substring(1)));
        }
        
        return ans;
    }
}