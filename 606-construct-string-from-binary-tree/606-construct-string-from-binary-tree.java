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
    public String tree2str(TreeNode root) {
        StringBuilder res = new StringBuilder();
        preorder(root, res);
        return res.toString();
    }
    
    public void preorder(TreeNode root, StringBuilder res){
        if(root==null){
            res.append("()");
            return;
        }
        
        res.append(root.val);
        
        if(root.left!=null){
            res.append("(");
            preorder(root.left, res);
            res.append(")");
        }
        
        if(root.right!=null){
            if(root.left == null){
                res.append("()");
            }
            res.append("(");
            preorder(root.right, res);
            res.append(")");
        }
    }
}