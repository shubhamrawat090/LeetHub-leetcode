class Solution {
    public String largestGoodInteger(String num) {
        int n = num.length();
        int ans = Integer.MIN_VALUE;
        if(n==3) {
            if(num.charAt(0)==num.charAt(1) && num.charAt(0)==num.charAt(2)) return num;
            return new String();
        }
        int i=0;
        while(i<n-2) {
            if(num.charAt(i) == num.charAt(i+1) && num.charAt(i) == num.charAt(i+2)) {
                ans = Math.max(ans, Integer.parseInt(num.substring(i,i+3)));
            }
            
            i++;
        }
        
        return ans == Integer.MIN_VALUE? new String(): (ans == 0? new String("000") : Integer.toString(ans));
    }
}