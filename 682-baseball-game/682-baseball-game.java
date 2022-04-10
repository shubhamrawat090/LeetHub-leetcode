class Solution {
    public int calPoints(String[] ops) {
        Stack<Integer> stk = new Stack<>();
        
        for(String op: ops){
            if(op.equals("+")){
                int first = stk.pop();
                int second = stk.pop();
                int sum = first + second;
                stk.push(second);
                stk.push(first);
                stk.push(sum);
            }else if(op.equals("D")){
                stk.push(2*stk.peek());
            }else if(op.equals("C")){
                stk.pop();
            }else{
                stk.push(Integer.parseInt(op));
            }
        }
        
        int score = 0;
        while(!stk.isEmpty()){
            score += stk.pop();
        }
        
        return score;
    }
}