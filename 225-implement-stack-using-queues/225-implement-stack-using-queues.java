class MyStack {
    Queue<Integer> q;

    public MyStack() {
        q = new ArrayDeque<>();
    }
    
    public void push(int x) {
        q.add(x);
    }
    
    public int pop() {
        if(empty()){
            // stack underflow
            return -1;
        }
        
        int counter = q.size();
        int val = 0;
        while(counter-- > 0){
            val = q.remove();
            //counter > 0 and not 1 because when remove happens size already decreases by 1
            if(counter > 0){
                q.add(val);
            }
        }
        
        return val;
    }
    
    public int top() {
        if(empty()){
            // stack underflow
            return -1;
        }
        
        int counter = q.size();
        int val = 0;
        while(counter-- > 0){
            val = q.remove();
            q.add(val);
        }
        
        return val;
        
    }
    
    public boolean empty() {
        return q.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */