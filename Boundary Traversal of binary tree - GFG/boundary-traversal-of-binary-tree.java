// { Driver Code Starts
import java.io.*;
import java.util.*;

class Node  
{ 
    int data; 
    Node left, right; 
   
    public Node(int d)  
    { 
        data = d; 
        left = right = null; 
    } 
}

class GFG
{
    static Node buildTree(String str)
    {
        // Corner Case
        if(str.length() == 0 || str.equals('N'))
            return null;
        String[] s = str.split(" ");
        
        Node root = new Node(Integer.parseInt(s[0]));
        Queue <Node> q = new LinkedList<Node>();
        q.add(root);
        
        // Starting from the second element
        int i = 1;
        while(!q.isEmpty() && i < s.length)
        {
              // Get and remove the front of the queue
              Node currNode = q.remove();
        
              // Get the current node's value from the string
              String currVal = s[i];
        
              // If the left child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the left child for the current node
                  currNode.left = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.left);
              }
        
              // For the right child
              i++;
              if(i >= s.length)
                  break;
              currVal = s[i];
        
              // If the right child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the right child for the current node
                  currNode.right = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.right);
              }
              
              i++;
        }
    
        return root;
    }
    
    public static void main(String args[]) throws IOException {
    
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t>0)
        {
            String s = br.readLine();
            Node root = buildTree(s);
            
            Solution T = new Solution();
            
            ArrayList <Integer> res = T.boundary(root);
            for (Integer num : res) System.out.print (num + " ");
            System.out.println();
            t--;
        }
    }
}
// } Driver Code Ends


//User function Template for Java

// class Node  
// { 
//     int data; 
//     Node left, right; 
   
//     public Node(int d)  
//     { 
//         data = d; 
//         left = right = null; 
//     } 
// }

class Solution
{
	ArrayList <Integer> boundary(Node node)
	{
	    ArrayList<Integer> ans = new ArrayList<>();
	    if(node == null){
	        //if tree doesn't exist then return empty arraylist
	        return ans;
	    }
	    ans.add(node.data);//add root's data
	    if(node.left==null && node.right==null){
	        //if root is a leaf node then return only root's data
	        return ans;
	    }
	   //root to left most path
	   ArrayList<Integer> leftMost = new ArrayList<>();
	   //send left child and not the root so that root doesn't repeat in answer
	   rootToLeftMost(node.left, leftMost); 
	   
	   //all leaf nodes except in leftmost and rightmost paths
	   ArrayList<Integer> leafs = new ArrayList<>();
	   //send right child and not the root so that root doesn't repeat in answer
	   allLeafs(node, leafs);
	   
	   //right most to root path
	   ArrayList<Integer> rightMost = new ArrayList<>();
	   rightMostToRoot(node.right, rightMost);
	   
	   ans.addAll(leftMost);
	   ans.addAll(leafs);
	   ans.addAll(rightMost);
	   
	   return ans;
	}
	
	void rootToLeftMost(Node node, ArrayList<Integer> lm){
	   if(node == null){//no node exists
	       return;
	   } 
	   
	   if(node.left==null && node.right==null){
	       //ignore leaf nodes
	        return;
	   }
	   
	   //add current node's data to ArrayList
	   lm.add(node.data);
	   if(node.left!=null){
	       //if left node exists then go to left node
	       rootToLeftMost(node.left, lm);
	   }else{
	       //if left node doesn't exist only then go to right node
	       rootToLeftMost(node.right, lm);
	   }
	   
	   return;
	}
	
	void allLeafs(Node node, ArrayList<Integer> leaf){
	    if(node == null) return;//no node exists
	    
	    if(node.left==null && node.right == null){
	        //if it is a leaf node then add its data to arraylist
	        leaf.add(node.data);
	        return;
	    }
	    
	    //if node is not leaf
	    allLeafs(node.left, leaf);//check its left child
	    allLeafs(node.right, leaf);//check its right child
	    
	    return;
	}
	
	void rightMostToRoot(Node node, ArrayList<Integer> rm){
	    if(node == null){
	        return;//no node exists, do nothing
	    }
	    
	    if(node.left == null && node.right == null){
	        //ignore leaf nodes
	        return;
	    }
	    
	    if(node.right!=null){
	       // if right child exists then go to right 
	        rightMostToRoot(node.right, rm);
	    }else{
	        // if right child doesn't exist only then go to left 
	        rightMostToRoot(node.left, rm);
	    }
	    //adding to arraylist happens in postorder because we need to add right boundary in reverse
	    rm.add(node.data);//add curr node's data to arraylist
	    
	    return;
	}
	
}
