class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stk = new Stack<>();
        stk.push(-1);
        int ans = 0;
        
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i)==')' && stk.size()>1 && s.charAt(stk.peek())=='(') {
                stk.pop();
                ans = Math.max(ans, i-stk.peek());
            } else {
                stk.push(i);
            }
        }
        
        return ans;
    }
}