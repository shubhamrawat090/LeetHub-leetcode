class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> ans = new ArrayList<>();
        
        for(String word: words) {
            if(isMatching(word, pattern)) {
                ans.add(word);
            }
        }
        
        return ans;
    }
    
    private boolean isMatching(String word, String pattern) {
        HashMap<Character, Character> patternToWord = new HashMap<>();
        HashMap<Character, Character> wordToPattern = new HashMap<>();
        
        for(int i=0; i<word.length(); i++) {
            char wordChar = word.charAt(i);
            char patternChar = pattern.charAt(i);
            
            if(!patternToWord.containsKey(patternChar)) {
                patternToWord.put(patternChar, wordChar);
            }
            
            if(!wordToPattern.containsKey(wordChar)) {
                wordToPattern.put(wordChar, patternChar);
            }
            
            if(patternToWord.get(patternChar) != wordChar || wordToPattern.get(wordChar) != patternChar) {
                return false;
            }
        }
        
        return true;
    }
}