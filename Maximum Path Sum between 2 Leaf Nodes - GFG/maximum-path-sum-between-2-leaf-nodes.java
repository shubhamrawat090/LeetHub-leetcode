// { Driver Code Starts
//Initial Template for Java

import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

class GFG {
    
    static Node buildTree(String str){
        
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        
        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue
        
        Queue<Node> queue = new LinkedList<>(); 
        
        queue.add(root);
        // Starting from the second element
        
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    static void printInorder(Node root){
        if(root == null)
            return;
            
        printInorder(root.left);
        System.out.print(root.data+" ");
        
        printInorder(root.right);
    }
    
    public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());

        while(t > 0){
            String s = br.readLine();
            Node root = buildTree(s);
            
            Solution ob = new Solution();
            System.out.println(ob.maxPathSum(root));
            t--;
        }
    }
}
// } Driver Code Ends


//User function Template for Java

/* class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
} */
class Solution
{
    int max = Integer.MIN_VALUE;
    int maxPathSum(Node root)
    { 
        // code here 
        //if both sides exist then find max while considering leafs on both sides
        if(root.left!=null && root.right!=null) {
            maxPathSum_Root2Leaf(root);
            return max;
        } 
        //only 1 side exists then consider root as leaf(according to GFG definition)
        else {
            int val = maxPathSum_Root2Leaf(root);
            return Math.max(max, val);
        }
    } 
    
    //return root to leaf sum and compares left+root+leaf for max Leaf to leaf node path
    public int maxPathSum_Root2Leaf(Node root) {
        if(root == null) return 0;
        
        //if both sides exists then get both sides root-leaf sum
        //COMPARE for max leaf-leaf path only if both sides exists
        if(root.left!=null && root.right!=null) {
            int left = maxPathSum_Root2Leaf(root.left);
            int right = maxPathSum_Root2Leaf(root.right);
            
            max = Math.max(max, left+root.data+right);
            return Math.max(left, right) + root.data;
        } 
        //if only 1 side exists then just return root-leaf path
        //DON'T consider in leaf-leaf path
        else if(root.left!=null) {
            int left = maxPathSum_Root2Leaf(root.left);
            return left + root.data;
        } else if(root.right!=null) {
            int right = maxPathSum_Root2Leaf(root.right);
            return right + root.data;
        } 
        //if only root exists then just return its value
        else {
            return root.data;
        }
    }
}