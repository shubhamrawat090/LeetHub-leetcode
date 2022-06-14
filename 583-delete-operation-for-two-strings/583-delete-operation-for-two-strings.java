class Solution {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length()+1][word2.length()+1];
        int common = longestCommonSubsequence(word1, word2, dp);
        
        return (word1.length() - common) + (word2.length() - common);
    }
    
    //TABULATE
    private int longestCommonSubsequence(String s1, String s2, int[][] dp) {
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
}