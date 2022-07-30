class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        int[] maxCounts = new int[26];
        List<String> res = new ArrayList<>();
        
        for (String word: words2) {
            int[] freq = freqOf(word);
            for (int i = 0; i < 26; i++) {
                maxCounts[i] = Math.max(maxCounts[i], freq[i]);
            }
        }
        
        for (String word: words1) {
            int[] freq = freqOf(word);
            boolean isValid = true;
            
            for (int i = 0; i < 26; i++) {
                if (maxCounts[i] > freq[i]) {
                    isValid = false;
                    break;
                }
            }
            
            if (isValid) {
                res.add(word);
            }
        }
        
        return res;
    }
    
    int[] freqOf(String word) {
        int[] freq = new int[26];
        for (char c: word.toCharArray()) {
            freq[c - 'a']++;
        }
        
        return freq;
    }

}