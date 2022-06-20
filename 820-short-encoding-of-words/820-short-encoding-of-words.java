class Solution {
    public int minimumLengthEncoding(String[] words) {
        //Take a word and check if there is any suffix of that word is present in the array and ignore that .
        HashMap<String, Integer> wordMap = new HashMap<>();
        
        int n = words.length;
        
        //frequency map for words
        for(int i=0;i<n;i++) { 
            wordMap.put(words[i], wordMap.getOrDefault(words[i], 0) + 1);
        }
        
        //checking if any suffix of curr word already exists in array => SKIP it
        for(int i=0;i<n;i++){
            for(int len=1;len<words[i].length();len++){
                String suffix = words[i].substring(len);
                
                //skipping the suffix by decreasing its frequency
                if(wordMap.containsKey(suffix)){
                    wordMap.put(suffix, wordMap.get(suffix) - 1);
                } 
            }  
        }
        
        // Encoded string : word1#word2#, length of encoded string = len(word1) + len(word2) + 2 #'s i.e. no. of words left in the frequency map after removing the suffixes present in array
        int countOfWords=0;
        int totalWordsLength=0;
        
         for(String i: wordMap.keySet()){
             if(wordMap.get(i) > 0){
                 countOfWords++;
                 totalWordsLength += i.length();
             }
         }
        
        return totalWordsLength + countOfWords;
    }
}