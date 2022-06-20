class Solution {
    public int minimumLengthEncoding(String[] words) {
        //Take a word and check if there is any suffix of that word is present in the array and ignore that .
        HashMap<String, Integer> valid = new HashMap<>();
        
        int n = words.length;
        
        for(int i=0;i<n;i++) { 
            valid.put(words[i], valid.getOrDefault(words[i], 0) + 1);
        }
        
        for(int i=0;i<n;i++){
            if(valid.get(words[i])>0){
                for(int len=1;len<words[i].length();len++){
                    if(valid.containsKey(words[i].substring(len))){
                        valid.put(words[i].substring(len), valid.get(words[i].substring(len)) - 1);
                    } 
                }  
            }
        }
        
        int count=0;
        int res=0;
        
         for(String i: valid.keySet()){
             if(valid.get(i) > 0){
                 count++;
                 res+= i.length();
             }
         }
        
        res += count;
        return res;
    }
}