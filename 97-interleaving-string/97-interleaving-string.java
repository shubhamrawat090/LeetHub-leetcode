class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s3.length() != s1.length() + s2.length()) {
            return false;
        }
        
        int[][] dp = new int[201][201];
        for(int[] d: dp) {
            Arrays.fill(d, -1);
        }
        
        // return rec(s1, s2, s3, 0, 0, 0);
        return memo(s1, s2, s3, 0, 0, 0, dp);
    }
    
    private boolean rec(String s1, String s2, String s3, int i, int j, int k) {
        if(k == s3.length()) {
            return true;
        }
        
        boolean case1 = false, case2 = false;
        
        if(i<s1.length() && s1.charAt(i) == s3.charAt(k)) {
            case1 = rec(s1, s2, s3, i+1, j, k+1);
        } 
        
        if(j<s2.length() && s2.charAt(j) == s3.charAt(k)) {
            case2 = rec(s1, s2, s3, i, j+1, k+1);
        }
        
        return case1 || case2;
    }
    
    private boolean memo(String s1, String s2, String s3, int i, int j, int k, int[][] dp) {
        if(k == s3.length()) {
            dp[i][j] = 1;
            return true;
        }
        
        if(dp[i][j] != -1) {
            if(dp[i][j] == 1) {
                return true;
            }
            
            return false;
        }
        
        boolean case1 = false, case2 = false;
        
        if(i<s1.length() && s1.charAt(i) == s3.charAt(k)) {
            case1 = memo(s1, s2, s3, i+1, j, k+1, dp);
        } 
        
        if(j<s2.length() && s2.charAt(j) == s3.charAt(k)) {
            case2 = memo(s1, s2, s3, i, j+1, k+1, dp);
        }
        
        boolean finalResult = case1 || case2;
        if(finalResult == false) {
            dp[i][j] = 0;
        } else {
            dp[i][j] = 1;
        }
        
        return finalResult;
    }
}