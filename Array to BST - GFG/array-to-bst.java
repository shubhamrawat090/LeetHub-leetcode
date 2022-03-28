// { Driver Code Starts
//Initial Template for Java

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
            int[] ans = obj.sortedArrayToBST(nums);
            for(int i = 0; i < ans.length; i++)
                System.out.print(ans[i] + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    class Node{
        int data;
        Node left;
        Node right;
        
        Node(){}
        Node(int data){
            this.data = data;
            left = null;
            right = null;
        }
    }
    
    public int[] sortedArrayToBST(int[] nums)
    {
        // Code here 
        Node root = helper(nums, 0, nums.length-1);
        
        ArrayList<Integer> ans = preorder(root);
        
        int[] finalAns = new int[ans.size()];
        int i = 0;
        for(int val: ans){
            finalAns[i++] = val;
        }
        
        return finalAns;
    }
    
    private ArrayList<Integer> preorder(Node root){
        if(root == null){
            return new ArrayList<>();
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        
        ans.add(root.data);
        ans.addAll(preorder(root.left));
        ans.addAll(preorder(root.right));
        
        return ans;
    } 
    
    private Node helper(int[] arr, int start, int end){
        if(start > end){
            //just like binary search STOP end start idx exceeds end idx
            return null;
        }
        int mid = start + (end - start)/2;
        
        Node root = new Node(arr[mid]);//root is the middle value of sorted arr
        
        //faith-> get BST converted for left subtree
        root.left = helper(arr, start, mid-1);
        
        //faith-> get BST converted for right subtree
        root.right = helper(arr, mid+1, end);
        
        return root;
    }
}