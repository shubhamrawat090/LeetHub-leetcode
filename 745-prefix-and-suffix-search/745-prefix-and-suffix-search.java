class WordFilter {
    String[] words;
    HashMap<String, Integer> dp;

    public WordFilter(String[] w) {
        this.words = w;
        this.dp = new HashMap<>();
    }
    
    public int f(String prefix, String suffix) {
        int ans = -1;
        
        String combPreSuf = prefix + "-" + suffix;
        
        if(dp.containsKey(combPreSuf)) {
            return dp.get(combPreSuf);
        }
        
        for(int i=0; i<words.length; i++) {
            String word = words[i];
            
            if(word.startsWith(prefix) && word.endsWith(suffix)) {
                ans = i;
            }
        }
        
        dp.put(combPreSuf, ans);
        
        return ans;
    }
}

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(prefix,suffix);
 */