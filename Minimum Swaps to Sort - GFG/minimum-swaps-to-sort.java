// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int[] nums = new int[n];
            String[] S = br.readLine().trim().split(" ");
            for(int i = 0; i < n; i++){
                nums[i] = Integer.parseInt(S[i]);
            }
            Solution obj = new Solution();
            int ans = obj.minSwaps(nums);
            System.out.println(ans);
       }
    }
}// } Driver Code Ends




class Solution
{
    //Function to find the minimum number of swaps required to sort the array.
    public int minSwaps(int nums[])
    {
        // Code here
        HashMap<Integer, Integer> pos = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            pos.put(nums[i], i);
        }
        
        Arrays.sort(nums);
        boolean[] vis = new boolean[nums.length];
        
        int swaps = 0;
        for(int itr=0; itr<nums.length; itr++) {
            if(vis[itr] || pos.get(nums[itr]) == itr) {
                continue;
            }
            
            vis[itr] = true;
            
            int cycleSize = 0;
            int cycleItr = itr;
            
            do {
                cycleItr = pos.get(nums[cycleItr]);
                vis[cycleItr] = true;
                cycleSize++;
            } while(cycleItr != itr);
            
            swaps += (cycleSize - 1);
        }
        
        return swaps;
    }
}