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
        if (root == null || (root.left == null && root.right == null) ) {
            return root;
        }
        
        // connect left child to right child
        if (root.left != null && root.right != null) {
            root.left.next = root.right;
        }
        
        // connect right child (or left if right is abasent) to child of next nodes.
        Node lNode = (root.right == null) ? root.left : root.right;
        
        Node next = root.next;
        while (next != null && next.left == null && next.right == null) {
            next = next.next;
        }

        if (next != null) {
            lNode.next = (next.left != null) ? next.left : next.right;
        }
        
        // process right child first
        connect(root.right);
        connect(root.left);
        
        return root;
    }
}