/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        //for leaf nodes and nodes that don't exist
        if(root == null || (root.left == null && root.right == null)) {
            return root;
        }
        
        //if both sides exists
        if(root.left!=null && root.right!=null) {
            root.left.next = root.right;
        }
        
        //if right child exists
        if(root.right!=null) {
            //if root.next has a node connected to it, join right's next to root.next's left
            if(root.next!=null)
                root.right.next = root.next.left;
            //otherwise leave it null
            else 
                root.right.next = null;
        }
        
        //go to left and right children and do the same
        connect(root.left);
        connect(root.right);
        
        //return our root
        return root;
    }
}