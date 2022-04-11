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
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;
        
        //get left and right subtree inverted
        TreeNode leftSubTreeInverted = invertTree(root.left);
        TreeNode rightSubTreeInverted = invertTree(root.right);
        
        //join left subtree to right of root and right subtree to left of root
        root.left = rightSubTreeInverted;
        root.right = leftSubTreeInverted;
        
        //return the tree
        return root;
    }
}