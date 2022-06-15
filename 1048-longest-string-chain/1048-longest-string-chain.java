class Solution {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a, b) -> a.length()-b.length());
        int res = 0;
        HashMap<String, Integer> memo = new HashMap<>();
        
        for(String word: words) {
            memo.put(word, 1);
            
            for(int i=0; i<word.length(); i++) {
                StringBuilder currWord = new StringBuilder(word);
                String delChar = currWord.deleteCharAt(i).toString();
                
                if(memo.containsKey(delChar)) {
                    memo.put(word, Math.max(memo.get(delChar)+1, memo.get(word)));
                }
            }
            
            res = Math.max(res, memo.get(word));
        }
        
        return res;
    }
}