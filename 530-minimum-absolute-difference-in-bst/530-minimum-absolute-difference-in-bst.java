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
    //stores the answer we need
    int minDiff = Integer.MAX_VALUE;
    //stores previous node for inorder traversal
    TreeNode prev = null;
    
    public int getMinimumDifference(TreeNode root) {
        if(root == null){
            return 0;
        }
        
        inorder(root);
        
        return minDiff;
    }
    
    private void inorder(TreeNode root){
        if(root == null){
            return;
        }
        
        //left call
        inorder(root.left);
        
        //inorder processing -> Node operation
        if(prev!=null){
            minDiff = Math.min(minDiff, Math.abs(prev.val - root.val));
        }
        
        prev = root;
        
        //right call
        inorder(root.right);
    }
}