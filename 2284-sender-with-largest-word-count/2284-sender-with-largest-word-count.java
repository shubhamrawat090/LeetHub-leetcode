class Solution {
    
    public String largestWordCount(String[] messages, String[] senders) {
        HashMap<String, Integer> map = new HashMap<>();
        
        int n = messages.length;
        
        //store name -> word count
        for(int i=0; i<n; i++) {
            String sender = senders[i];
            String message = messages[i];
            
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
        ArrayList<String> names = new ArrayList();
        int max = 0;
        String ans = "";
        for(String key: map.keySet()) {
            int val = map.get(key);
            if(val>max) {
                max = val;
            }
        }
        
        for(String key: map.keySet()) {
            int val = map.get(key);
            if(val == max) {
                names.add(key);
            }
        }
        
        Collections.sort(names);
        ans = names.get(names.size()-1);
        return ans;
    }
}