/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode convertBST(TreeNode root) {
        rec(root, 0);
        return root ;
    }
    
    public int rec(TreeNode node , int prevSum){
        //add the value of rightSubTree to node
        //pass this as prevSum to add to leftSubTree
        //return the value of leftSubTree
        if(node == null)
            return prevSum ;
        int rightValue = rec(node.right, prevSum);
        node.val += rightValue ;
        int leftValue = rec(node.left, node.val);
        return leftValue ;
    }
}

