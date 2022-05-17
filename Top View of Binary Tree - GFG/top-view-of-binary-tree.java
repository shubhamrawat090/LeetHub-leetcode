// { Driver Code Starts
//Initial Template for JAVA

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

public class Tree {
    
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
    	    	
                Solution ob = new Solution();

                ArrayList<Integer> vec = ob.topView(root);
                for(int x : vec)
                    System.out.print(x + " ");
                System.out.println();
        	
                t--;   
        }
    }
}// } Driver Code Ends


//User function Template for Java

/*
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
*/

class Solution
{
    static class Pair {
        Node node;
        int vertical = 0;
        
        Pair(Node n, int v) {
            node = n;
            vertical = v;
        }
    }
    //Function to return a list of nodes visible from the top view 
    //from left to right in Binary Tree.
    static ArrayList<Integer> topView(Node root)
    {
        // add your code
        int leftV = 0, rightV = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        
        Pair p = new Pair(root, 0);
        
        HashMap<Integer, Node> map = new HashMap<>();
        
        //BFS
        Queue<Pair> q = new ArrayDeque<>();
        q.add(p);
        
        while(q.size()!=0) {
            Pair rPair = q.remove();
            
            //Finding Maximum left and right vertical points
            leftV = Math.min(leftV, rPair.vertical);
            rightV = Math.max(rightV, rPair.vertical);
            
            //add in hashmap only if it isn't present i.e. occurs for the first time only
            if(!map.containsKey(rPair.vertical)) {
                map.put(rPair.vertical, rPair.node);
            }
            
            //add left and right children in queue if they are present
            if(rPair.node.left!=null) {
                q.add(new Pair(rPair.node.left, rPair.vertical - 1));
            }
            
            if(rPair.node.right!=null) {
                q.add(new Pair(rPair.node.right, rPair.vertical + 1));
            }
        }
        
        //get values inside hashmap in the order of the vertical levels in asc order
        for(int i=leftV; i<=rightV; i++) {
            ans.add(map.get(i).data);
        }
        
        return ans;
    }
}