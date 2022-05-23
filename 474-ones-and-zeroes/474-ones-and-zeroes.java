class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m+1][n+1];
        int ones=0;
        int zeros=0;
        int[] count = new int[2];
        for(String str: strs){
            //get zeroes and ones count
            count01(str, count);
            zeros = count[0];
            ones = count[1];
            for(int i=m;i>=zeros;i--){
                for(int j=n;j>=ones;j--){
                   dp[i][j] = Math.max(dp[i][j], dp[i - zeros][j - ones] + 1);
                }
            }
            
        }
        return dp[m][n];
        
    }
    
    public void count01(String s, int[] count) {
        int z = 0, o = 0;
            for (char ch : s.toCharArray()) {
                if (ch == '1')
                    o++;
                else
                    z++;
        }
        count[0] = z;
        count[1] = o;
    } 
    
}