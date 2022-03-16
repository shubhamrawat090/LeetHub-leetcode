// { Driver Code Starts
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

class GfG {
    
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
    static void printInorder(Node root)
    {
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
        	    Tree g = new Tree();
    			ArrayList<Integer> result = g.leftView(root);
    			for(int value : result){
    			    System.out.print(value + " ");
    			}
    			System.out.println();
                t--;
        }
    }
}
// } Driver Code Ends


//User function Template for Java

/* A Binary Tree node
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}*/
class Tree
{
    //Function to return list containing elements of left view of binary tree.
    ArrayList<Integer> leftView(Node root)
    {
      // Your code here
      ArrayList<ArrayList<Integer>> levels = levelOrder(root);
      ArrayList<Integer> ans = new ArrayList<>();
      
      for(ArrayList<Integer> level: levels){
          ans.add(level.get(0));
      }
      
      return ans;
    }
    
    public ArrayList<ArrayList<Integer>> levelOrder(Node root) {
        if(root == null) return new ArrayList<>();
        
        //list containing all nodes levelwise
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        
        //queue for processing
        Queue<Node> q = new ArrayDeque<>();
        
        //add root to queue
        q.add(root);
        
        //work till queue is empty
        while(!q.isEmpty()){
            //currently queue contains nodes of a particular so do this size no. of times
            int count = q.size();
            
            //list for nodes of current level
            ArrayList<Integer> levels = new ArrayList<>();
            
            while(count-- > 0){
                //remove front node of queue as it contains first node of that level from left -> right
                Node curr = q.remove();
                //add that value to levels list
                levels.add(curr.data);
                
                //get the left child of current tree if it exists
                if(curr.left!=null) q.add(curr.left);
                //get the right child of current tree if it exists
                if(curr.right!=null) q.add(curr.right);
            }
            
            //add that level to our ans
            ans.add(levels);
        }
        
        return ans;
    }
}