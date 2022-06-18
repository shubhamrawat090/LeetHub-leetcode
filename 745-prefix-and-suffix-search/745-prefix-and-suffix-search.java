class WordFilter {
    HashMap<String,Integer> map;
    public WordFilter(String[] words) {
        
        String prefix="", suffix="";
        
        map = new HashMap<String,Integer>();
        
        for(int i=0;i<words.length;i++) {
            for(int j=0;j<words[i].length();j++) {
                
                prefix= words[i].substring(0,j+1);
                
                for(int k=words[i].length()-1;k>=0;k--) {
                    
                    suffix = words[i].substring(k);
                    map.put(prefix+"#"+suffix,i);
                }
            }
        }
    }

    public int f(String prefix, String suffix) {
       return map.getOrDefault(prefix+"#"+suffix,-1);
    }
}

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(prefix,suffix);
 */