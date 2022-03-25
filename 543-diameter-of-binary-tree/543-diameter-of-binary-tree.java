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
    int diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return diameter;
    }
    
    public int height(TreeNode root){
        if(root == null){
            return -1;
        }
        
        int lh = height(root.left);
        int rh = height(root.right);
        
        int myDia = lh + rh + 2;
        diameter = Math.max(diameter, myDia);
        
        return Math.max(lh, rh) + 1;
    }
}