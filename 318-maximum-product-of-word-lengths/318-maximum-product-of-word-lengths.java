// Bit Manipulation Approach 
// Time: O(N*N), Space: O(N)

class Solution {
    //integer bits allow us to store till 32 bits and english letters are only 26, so it will accomodate it easily
    // a = 0th bit, b = 1st bit, c = 2nd bit, ....... z = 25th bit
    //for word abc : state = 1 1 1 0 0 0 0 0 .... till 32 bits
    //for word abd : state = 1 1 0 1 0 0 0 0 .... till 32 bits
    //for word def : state = 0 0 0 1 1 1 0 0 .... till 32 bits
    // abc & abd != 0 as they have bits in common => letters in common
    // abc & def == 0 as they have no bits in common => no letters in common
    public int maxProduct(String[] words) {
        int n = words.length;
        int[] states = new int[n];
        
        for(int i=0; i<n; i++) {
            String word = words[i]; 
            states[i] = getState(words[i]);
        }
        
        int maxPr = 0;
        for(int i=0; i<n; i++) {
            for(int j=i+1; j<n; j++) {
                if((states[i]&states[j])==0) {
                    maxPr = Math.max(maxPr, words[i].length()*words[j].length());
                }
            }
        }
        
        return maxPr;
    }
    
    private int getState(String word) {
        int state = 0;
        
        for(int i=0; i<word.length(); i++) {
            //take 1 char
            char c = word.charAt(i);
            //left shift till that chars position
            int currCharPosition = 1<<(c-'a');
            //OR it with previous chars state
            state = state | currCharPosition;
        }
        
        return state;
    }
}