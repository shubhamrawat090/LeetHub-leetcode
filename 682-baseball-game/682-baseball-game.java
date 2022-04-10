class Solution {
    public int calPoints(String[] ops) {
        Stack<Integer> stk = new Stack<>();
        
        for(String op: ops){
            if(op.equals("+")){
                //add prev 2
                int topVal = stk.pop();
                int bottomVal = stk.pop();
                int newVal = topVal + bottomVal;
                
                //push bottomVal
                stk.push(bottomVal);
                
                //push topVal
                stk.push(topVal);
                
                //push newVal
                stk.push(newVal);
                
            }else if(op.equals("C")){
                //remove prev
                stk.pop();
                
            }else if(op.equals("D")){
                //double
                stk.push(2*stk.peek());
                
            }else{
                //number
                stk.push(Integer.parseInt(op));
            }
        }
        
        int score = 0;
        //calculate score stored in stack
        while(!stk.isEmpty()){
            score += stk.pop();
        }
        
        return score;
    }
}