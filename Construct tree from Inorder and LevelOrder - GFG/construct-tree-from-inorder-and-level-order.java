// { Driver Code Starts
import java.util.*;

class Node
{
    int data;
    Node left, right;
    
    Node(int item)
    {
        data = item;
        left = right = null;
    }    
        public void setLeft(Node left) 
    {
        this.left = left;
    }
  
    public void setRight(Node right) 
    {
        this.right = right;
    }
        
    
}


class ConstructBT
{
    Node root;
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
	    int t = sc.nextInt();
	    
	    while(t-- > 0)
	    {
	        int n = sc.nextInt();
	        
	        int inord[] = new int[n];
	        int level[] = new int[n];
	        for(int i = 0; i < n; i++)
	            inord[i] = sc.nextInt();
	            
	        for(int i = 0; i < n; i++)
	             level[i] = sc.nextInt();
	             
	        GfG g = new GfG();
	        Node node =  g.buildTree(inord, level);
	        printPreOrder(node);
	        System.out.println();
	        
	        
	    }
    }
    
   static void printPreOrder(Node node)
   {
       if(node == null)
          return;
          
        System.out.print(node.data + " ");
        printPreOrder(node.left);
        printPreOrder(node.right);
   }
}
// } Driver Code Ends


/*Please note that it's Function problem i.e.
you need to write your solution in the form of Function(s) only.
Driver Code to call/invoke your function is mentioned above.*/

/*Complete the function below*/
class GfG
{
    Node buildTree(int inord[], int level[])
    {
        //your code here
        
        //using hashmap to store levelorder to make searching faster
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<level.length; i++) {
            map.put(level[i], i);
        }
        
        return construct(inord, map, 0, inord.length-1);
    }
    
    Node construct(int[] in, HashMap<Integer, Integer> map, int inLo, int inHi) {
        if(inLo>inHi) {
            return null;
        }
        
        int minIdx = inLo;
        for(int i=inLo+1; i<=inHi; i++) {
            if(map.get(in[minIdx]) > map.get(in[i])) {
                minIdx = i;
            } 
        }
        
        Node root = new Node(in[minIdx]);
        root.left = construct(in, map, inLo, minIdx-1);
        root.right = construct(in, map, minIdx+1, inHi);
        
        return root;
    }
}


