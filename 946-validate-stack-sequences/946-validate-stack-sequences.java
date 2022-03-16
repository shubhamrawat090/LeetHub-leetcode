class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stk = new Stack<>();
        int j=0;
        
        for(int val: pushed){
            stk.push(val);
            while(!stk.isEmpty() && stk.peek()==popped[j]){
                stk.pop();
                j++;
            }
        }
        
        return stk.isEmpty();
    }
}