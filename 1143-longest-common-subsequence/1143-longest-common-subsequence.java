class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length()+1][text2.length()+1];
        // for(int[] d: dp) {
        //     Arrays.fill(d, -1);
        // }
        
        // return memo(text1, text2, 0, 0, dp);
        // return helper(text1, text2, 0, 0);
        return tab(text1, text2, dp);
    }
    
    //TABULATE
    private int tab(String s1, String s2, int[][] dp) {
        for(int idx1=s1.length()-1; idx1>=0; idx1--) {
            for(int idx2=s2.length()-1; idx2>=0; idx2--) {
                //0 length cannot have any subsequence
                if(idx1==s1.length() || idx2==s2.length()) {
                    dp[idx1][idx2] = 0;
                    continue;
                }

                //found 1 common character, so increment the common subsequence length by 1
                if(s1.charAt(idx1) == s2.charAt(idx2)) {
                    //also go to next character of both strings
                    dp[idx1][idx2] = 1 + dp[idx1+1][idx2+1];
                    continue;
                }

                //no common character
                //2 scenarios possible

                //skip s1's current char
                int skip1 = dp[idx1+1][idx2];
                //skip s2's current char
                int skip2 = dp[idx1][idx2+1];

                //maximum of both the scenarios is returned
                dp[idx1][idx2] = Math.max(skip1, skip2);
            }
        }
        
        return dp[0][0];
    }
    
    // MEMOIZED
    private int memo(String s1, String s2, int idx1, int idx2, int[][] dp) {
        //0 length cannot have any subsequence
        if(idx1==s1.length() || idx2==s2.length()) {
            return dp[idx1][idx2] = 0;
        }
        
        if(dp[idx1][idx2] != -1) {
            return dp[idx1][idx2];
        }
        
        //found 1 common character, so increment the common subsequence length by 1
        if(s1.charAt(idx1) == s2.charAt(idx2)) {
            //also go to next character of both strings
            return dp[idx1][idx2] = 1 + memo(s1, s2, idx1+1, idx2+1, dp);
        }
        
        //no common character
        //2 scenarios possible
        
        //skip s1's current char
        int skip1 = memo(s1, s2, idx1+1, idx2, dp);
        //skip s2's current char
        int skip2 = memo(s1, s2, idx1, idx2+1, dp);
        
        //maximum of both the scenarios is returned
        return dp[idx1][idx2] = Math.max(skip1, skip2);
    }
    
    // RECURSIVE - TLE
    private int helper(String s1, String s2, int idx1, int idx2) {
        //0 length cannot have any subsequence
        if(idx1==s1.length() || idx2==s2.length()) {
            return 0;
        }
        
        //found 1 common character, so increment the common subsequence length by 1
        if(s1.charAt(idx1) == s2.charAt(idx2)) {
            //also go to next character of both strings
            return 1 + helper(s1, s2, idx1+1, idx2+1);
        }
        
        //no common character
        //2 scenarios possible
        
        //skip s1's current char
        int skip1 = helper(s1, s2, idx1+1, idx2);
        //skip s2's current char
        int skip2 = helper(s1, s2, idx1, idx2+1);
        
        //maximum of both the scenarios is returned
        return Math.max(skip1, skip2);
    }
}