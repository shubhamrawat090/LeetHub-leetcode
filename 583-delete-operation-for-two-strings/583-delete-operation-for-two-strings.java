class Solution {
    public int minDistance(String text1, String text2) {
        int[][] dp = new int[text1.length()+1][text2.length()+1];
        for(int i=0;i<=text1.length();i++){
            for(int j=0;j<=text2.length();j++){
                //for 1 string is empty and other is non empty then you have to delete all the characters of non empty string
                if(i==0 || j==0){
                    dp[i][j] = i+j;
                }
                //for same characters in both strings, you don't have to delete anything, just take the previous result
                else if(text1.charAt(i-1)==text2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }
                //for different characters in both strings, delete 1 character from minimun of both the scenarios
                else{
                    dp[i][j] = 1 + Math.min(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        //result at last of the dp 
        return dp[text1.length()][text2.length()];
    }
}