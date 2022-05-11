// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().split(" ");

            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            int[] ans = new Solve().findTwoElement(a, n);
            System.out.println(ans[0] + " " + ans[1]);
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Solve {
    int[] findTwoElement(int arr[], int n) {
        /* Will hold xor of all elements and numbers from 1 to n */
        int xor1;
    
        /* Will have only single set bit of xor1 */
        int set_bit_no;
    
        int i;
        int x = 0; // missing
        int y = 0; // repeated
    
        xor1 = arr[0];
    
        /* Get the xor of all array elements */
        for (i = 1; i < n; i++)
            xor1 = xor1 ^ arr[i];
    
        /* XOR the previous result with numbers from 1 to n */
        for (i = 1; i <= n; i++)
            xor1 = xor1 ^ i;
    
        /* Get the rightmost set bit in set_bit_no */
        set_bit_no = xor1 & ~(xor1 - 1);
    
        /* Now divide elements into two sets by comparing a rightmost set bit
           of xor1 with the bit at the same position in each element.
           Also, get XORs of two sets. The two XORs are the output elements.
           The following two for loops serve the purpose */
    
        for (i = 0; i < n; i++) {
            if ((arr[i] & set_bit_no) == 0)
                /* arr[i] belongs to first set */
                x = x ^ arr[i];
    
            else
                /* arr[i] belongs to second set */
                y = y ^ arr[i];
        }
    
        for (i = 1; i <= n; i++) {
            if ((i & set_bit_no) == 0)
                /* i belongs to first set */
                x = x ^ i;
    
            else
                /* i belongs to second set */
                y = y ^ i;
        }
    
        // NB! numbers can be swapped, maybe do a check ?
        int x_count = 0;
        for (int j=0; j<n; j++) {
            if (arr[j]==x)
                x_count++;
        }
        
        if (x_count==0)
            return new int[]{y, x};
        
        return new int[]{x, y};
    }
}