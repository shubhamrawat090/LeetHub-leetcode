class Solution {
    public int fib(int n) {
        return spaceOptimized(n);
    }
    
    private int spaceOptimized(int n) {
        int first = 0, second = 1;
        
        if(n == 0) {
            return first;
        }
        if(n == 1) {
            return second;
        }
        for(int i=2; i<=n; i++) {
            int ans = first + second;
            first = second;
            second = ans;
        }
        
        return second;
    }
}