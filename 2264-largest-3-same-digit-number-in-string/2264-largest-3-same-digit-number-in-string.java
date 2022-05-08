class Solution {
    public String largestGoodInteger(String num) {
        int n = num.length();
        int ans = Integer.MIN_VALUE;
        //if 3 length string
        if(n==3) {
            //return the num if all 3 chars are same
            if(num.charAt(0)==num.charAt(1) && num.charAt(0)==num.charAt(2)) return num;
            return new String();
        }
        //iterate the list
        
        for(int i=0; i<n-2; i++) {
            //if we find 3 same digit no.
            if(num.charAt(i) == num.charAt(i+1) && num.charAt(i) == num.charAt(i+2)) {
                //store the maximum of all those numbers
                ans = Math.max(ans, Integer.parseInt(num.substring(i,i+3)));
            }
        }
        
        //if ans is still -infinity and return empty string
        //otherwise if ans = 0, return "000"
        //otherwise return the ans as a String
        return ans == Integer.MIN_VALUE? new String(): (ans == 0? new String("000") : Integer.toString(ans));
    }
}