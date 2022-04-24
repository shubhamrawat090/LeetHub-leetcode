// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

public class GFG {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(in.readLine().trim());
        while (tc-- > 0) {
            String S1 = in.readLine();
            String S2 = in.readLine();
            Solution ob = new Solution();
            System.out.println( ob.countWays(S1,S2) );
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution {
    int countWays(String S1, String S2) { 
        // code here 
        return count(S1, S2, S1.length(), S2.length());
    }
    
    // Recursive function to find the number of times
    // the second string occurs in the first string,
    // whether continuous or discontinuous
    int count(String a, String b, int m, int n)
    {
        // If both first and second string is empty,
        // or if second string is empty, return 1
        if ((m == 0 && n == 0) || n == 0)
            return 1;//found 1 matching subsequence
     
        // If only first string is empty and
        // second string is not empty, return 0
        if (m == 0)
            return 0;//subsequence not matching
     
        // If last characters are same
        // Recur for remaining strings by
        // 1. considering last characters of
        // both strings
        // 2. ignoring last character of
        // first string
        if (a.charAt(m - 1) == b.charAt(n - 1)){
            //done via decreasing length of both strings by 1
            int ignoreLastCharOfBoth = count(a, b, m - 1, n - 1);
            //done via decreasing length of first string by 1
            int ignoreLastCharOfFirst = count(a, b, m - 1, n);
            //add both answers and return
            return ignoreLastCharOfBoth + ignoreLastCharOfFirst;
        }
        else
            // If last characters are different, 
            // ignore last char of first string
            // and recur for  remaining string
            //done via decreasing length of first string by 1 
            return count(a, b, m - 1, n);
    }
}