class Solution {
    public String removeDuplicateLetters(String s) {
        //stack for processing characters
        Stack<Character> stk = new Stack<>();
        int[] freq = new int[26]; //frequency of each character in string
        boolean[] exists = new boolean[26]; //mark true is character as been already pushed in stack
        
        //storing frequency of each character of string
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            freq[ch - 'a']++;
        }
         
        for(int i=0; i<s.length(); i++){
            //processing string character by character
            char ch = s.charAt(i);
            //decrementing freq of character as it is processed now
            freq[ch - 'a']--;
            //if character already exists in stack then don't need to add it again
            if(exists[ch - 'a']) continue;
            
            //check top of stack that if your ch to be added is smaller that it
            //if our ch < stk.peek() and freq[stk.peek()]>0 it means this top character can be replaced with our ch as we can have to chance to add this character later since it is still present in the remaining string
            while(stk.size()>0 && stk.peek()>ch && freq[stk.peek() - 'a']>0){
                char removed = stk.pop();
                //set exists false for a character that has been removed from stack
                exists[removed - 'a'] = false;
            }
            
            //push our character in stack
            stk.push(ch);
            //set exist for our character true as it is now present in stack
            exists[ch - 'a'] = true;
        }
        
        //store characters of stack in reverse order to get our desired string
        char[] arr = new char[stk.size()];
        int i = arr.length-1;
        while(stk.size()>0){
            arr[i] = stk.pop();
            i--;
        }
        
        return new String(arr);
    }
}