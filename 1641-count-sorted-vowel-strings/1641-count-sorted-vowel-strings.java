// Recursive: Time = O(5^n)
class Solution {
    //considering a=0, e=1, i=2, o=4, u=5
    //vowel arr
    char[] vowel = new char[]{'a','e','i','o','u'};
    
    public int countVowelStrings(int n) {
        int ans = 0;
        
        //we start iterating from back(considering our c to be last character of a string of length n) 
        //and we count all possible combinations corresponding to each character in the vowel arr
        int[][] dp = new int[n+1][5];
        
        for(int[] row: dp) {
            Arrays.fill(row,-1);
        }
        
        for(int i=0; i<5; i++) {
            ans += memo(n-1, i, dp);
        }
        
        return ans;
    }
    
    //memoized function
    private int memo(int length, int lastChar, int[][] dp) {
        if(length == 0) {
            //when length becomes 0, it means it is the 1 and only string that we need
            return dp[length][lastChar]  = 1;
        }
        
        if(dp[length][lastChar] != -1) {
            return dp[length][lastChar];
        }
        
        //store combinations from the curr characters with lastChar >= curr char
        int temp = 0;
        
        for(int i=0; i<5; i++) {
            //ensure lexicographical order
            if(vowel[lastChar]>=vowel[i]) {
                //current char is parsed, now consider for length-1 string remaining
                //our curr char becomes lastChar now
                temp += memo(length-1, i, dp);
            }
        }
        
        return dp[length][lastChar] = temp;
    }
}