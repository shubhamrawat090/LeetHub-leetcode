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
    int minDiff = Integer.MAX_VALUE;
    TreeNode prev = null;
    
    public int minDiffInBST(TreeNode root) {
        if(root == null){
            return 0;
        }
        
        inorder(root);
        
        return minDiff;
    }
    
    private void inorder(TreeNode root){
        if(root == null) return;
        
        inorder(root.left);
        
        if(prev!=null){
            minDiff = Math.min(minDiff, Math.abs(prev.val-root.val));
        }
        
        prev = root;
        
        inorder(root.right);
    }
}