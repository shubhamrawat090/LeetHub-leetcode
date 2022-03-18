class Solution {
    public String removeDuplicateLetters(String s) {
        Stack<Character> stk = new Stack<>();
        int[] freq = new int[26];
        boolean[] exists = new boolean[26];
        
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            freq[ch - 'a']++;
        }
        
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            freq[ch - 'a']--;
            if(exists[ch - 'a']) continue;
            
            while(stk.size()>0 && stk.peek()>ch && freq[stk.peek() - 'a']>0){
                char removed = stk.pop();
                exists[removed - 'a'] = false;
            }
            
            stk.push(ch);
            exists[ch - 'a'] = true;
        }
        
        char[] arr = new char[stk.size()];
        int i = arr.length-1;
        while(stk.size()>0){
            arr[i] = stk.pop();
            i--;
        }
        
        return new String(arr);
    }
}