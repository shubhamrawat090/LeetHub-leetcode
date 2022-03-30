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
    public TreeNode bstToGst(TreeNode root) {
        if(root == null){
            return root;
        }
        
        inorder(root);
        
        return root;
    }
    
    int sum = 0;
    void inorder(TreeNode root){
        if(root == null) return;
        
        inorder(root.right);
        
        sum += root.val;
        root.val = sum;
        
        inorder(root.left);
    }
    
    
}