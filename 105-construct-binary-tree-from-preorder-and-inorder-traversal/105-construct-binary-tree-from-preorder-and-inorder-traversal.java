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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode root = construct(0, preorder.length-1, 0, inorder.length-1, preorder, inorder);
        return root;
    }
    
    private TreeNode construct(int pre_lo, int pre_hi, int in_lo, int in_hi, int[] pre, int[] in) {
        //base case
        if(pre_lo > pre_hi) {
            return null;
        }
        
        TreeNode node = new TreeNode();
        
        node.val = pre[pre_lo];
        
        int idx = in_lo;
        while(in[idx]!=pre[pre_lo] && idx<=in_hi) {
            idx++;
        }
        
        int lhs = idx - in_lo;
        
        node.left = construct(pre_lo+1, pre_lo+lhs, in_lo, idx-1, pre, in);
        node.right = construct(pre_lo+lhs+1, pre_hi, idx+1, in_hi, pre, in);
        
        return node;
    }
}