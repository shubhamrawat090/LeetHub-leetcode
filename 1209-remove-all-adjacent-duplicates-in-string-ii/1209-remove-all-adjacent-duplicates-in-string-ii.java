// Time: O(N), Space: O(N)
class Solution {
    public String removeDuplicates(String s, int k) {
        //in stack we store values like {char, count} and if the count matches k then we remove the value from stack
        Stack<int[]> main = new Stack<>();
        
        for(char c: s.toCharArray()){
            //main.peek()[0] -> character
            //main.peek()[1] -> count
            
            //if top char of stack matches our curr string char, then we increment the count
            if(!main.isEmpty() && main.peek()[0] == c){
                main.peek()[1]++;
            }
            //otherwise we just push the character with count = 1
            else{
                main.push(new int[]{c,1});
            }
            
            //if our count matches k then we pop it
            if(main.peek()[1]==k){
                main.pop();
            }
        }
        
        //convert resultant stack to string using stringbuilder
        StringBuilder sb= new StringBuilder();
        
        while(!main.isEmpty()){
            int[] top = main.pop();
            
            //append the char count no. of times
            while(top[1]-->0)
                sb.append((char) top[0]);
        }
        
        //reverse as stack is in LIFO
        return sb.reverse().toString();
    }
}
