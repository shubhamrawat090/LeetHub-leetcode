class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m+1][n+1];
        int ones=0;
        int zeros=0;
        for(String s:strs){
            int[] count = count01(s);
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
    
    public int[] count01(String s) {
        int z = 0, o = 0;
            for (char ch : s.toCharArray()) {
                if (ch == '1')
                    o++;
                else
                    z++;
        }
        return new int[]{z, o};
    } 
    
}