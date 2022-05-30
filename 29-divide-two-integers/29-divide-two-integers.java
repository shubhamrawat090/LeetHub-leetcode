class Solution {
    public int divide(int dividend, int divisor) {
        //for divide by 0, and -infinite/-1, return infinity
        if(divisor==0 || dividend==Integer.MIN_VALUE && divisor==-1) {
            return Integer.MAX_VALUE;
        }
           
        //contains result
        int res = 0;
        //if both sign same then +ve else -ve
        int sign = (dividend<0)^(divisor<0)? -1: 1;
        
        //get the absolute values for dividend and divisor
        long dvd=Math.abs((long)dividend);
        long dvs=Math.abs((long)divisor);
        
        //do this till divisor <= divident
        while(dvs<=dvd){
            
            long temp=dvs;
            long mul=1;
            
            while(dvd>=temp<<1){
                temp<<=1;
                mul<<=1;
            }
            
            dvd-=temp;
            res+=mul;
        }
        
        return sign==1?res:-res;
    }
}