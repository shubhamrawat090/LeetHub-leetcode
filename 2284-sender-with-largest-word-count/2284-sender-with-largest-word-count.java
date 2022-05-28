class Solution {
    
    public String largestWordCount(String[] messages, String[] senders) {
        HashMap<String, Integer> map = new HashMap<>();
        
        int n = messages.length;
        
        //store name -> word count
        for(int i=0; i<n; i++) {
            String sender = senders[i];
            String message = messages[i];
            
            //count no. of words
            // int words = message.split(" ").length;
            int words = 1;
            for(char c: message.toCharArray()) {
                if(c==' ') words++;
            }
            
            if(!map.containsKey(sender)) {
                map.put(sender, words);
            } else {
                map.put(sender, map.get(sender)+words);
            }
        }
        
        //get highest word count
        int max = 0;
        for(String key: map.keySet()) {
            int val = map.get(key);
            if(val>max) {
                max = val;
            }
        }
        
        //Store the names with same max word count 
        ArrayList<String> names = new ArrayList();
        for(String key: map.keySet()) {
            int val = map.get(key);
            if(val == max) {
                names.add(key);
            }
        }
        
        //sort the array to get lexicographically highest
        Collections.sort(names);
        return names.get(names.size()-1);
    }
}