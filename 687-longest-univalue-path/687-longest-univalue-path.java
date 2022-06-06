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
    int path = 0;
    public int longestUnivaluePath(TreeNode root) {
        helper(root);
        return path;
    }
    
    private int helper(TreeNode root) {
        if(root == null) {
            return 0;
        }
        
        int left = helper(root.left);
        int right = helper(root.right);
        
        int retPath = 0;
        
        if(root.left!=null && root.left.val == root.val) {
            retPath = Math.max(retPath, left+1);
        } 
        
        if(root.right!=null && root.right.val == root.val) {
            retPath = Math.max(retPath, right+1);
        }
        
        path = Math.max(path, retPath);
        
        if(root.left!=null && root.left.val == root.val && root.right!=null && root.right.val == root.val) {
            path = Math.max(path, left+right+2);
        }
        
        return retPath;
    }
}