class Solution {
    public double myPow(double x, int n) {
        if(n < 0) {
            x = 1/x;
        }
        
        return helper(x, n);
    }
    
    private double helper(double x, int n) {
        if(n == 0) {
            return 1;
        }
        
        double xNb2 = helper(x, n/2);
        double ans = xNb2 * xNb2;
        
        if((n&1) != 0) {
            ans *= x;
        }
        
        return ans;
    }
}