// { Driver Code Starts
// Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class Recursion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();//total testcases
        while (T-- > 0) {
            Hanoi obj = new Hanoi();
            int N;
            
            //taking input N
            N = sc.nextInt();

            //calling toh() method 
            System.out.println(obj.toh(N, 1, 3, 2));
        }
    }
}





// } Driver Code Ends


// User function Template for Java


// avoid space at the starting of the string in "move disk....."
class Hanoi {
    
    public long toh(int N, int from, int to, int aux) {
        // Your code here
        if(N == 0){
            return N;
        }
        long steps = 0;
        
        //move n-1 disks to auxillary tower
        steps += toh(N-1, from, aux, to);
        //move 1 disk from tower "from" to tower "to"
        System.out.println("move disk "+ N + " from rod "+ from + " to rod " + to);
        steps += 1;
        //move n-1 disks back to tower "to" from "aux"
        steps += toh(N-1, aux, to, from);
        
        return steps;
        
    }
}
