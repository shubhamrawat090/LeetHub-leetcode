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
        char[] patternToWord = new char[26];
        char[] wordToPattern = new char[26];
        
        for(int i=0; i<word.length(); i++) {
            char wordChar = word.charAt(i);
            char patternChar = pattern.charAt(i);
            
            if(patternToWord[patternChar - 'a'] == 0) {
                patternToWord[patternChar - 'a'] = wordChar;
            }
            
            if(wordToPattern[wordChar - 'a'] == 0) {
                wordToPattern[wordChar - 'a'] = patternChar;
            }
            
            if(patternToWord[patternChar - 'a'] != wordChar || wordToPattern[wordChar - 'a'] != patternChar) {
                return false;
            }
        }
        
        return true;
    }
}