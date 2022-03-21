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
    public boolean isSymmetric(TreeNode root) {
        
        if(root == null) return true;
        
        return isSameTree(root.left, root.right); 
    }
    
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if((p == null && q != null) || (q == null && p != null)) return false;
        
        if(p == null && q == null) return true;
        
        return isSameTree(p.left, q.right) && isSameTree(p.right, q.left) && (p.val==q.val);
    }
}