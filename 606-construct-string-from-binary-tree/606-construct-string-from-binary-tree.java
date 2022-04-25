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
            return;
        }
        
        //add root value
        res.append(root.val);
        
        //process left
        if(root.left!=null){
            //add left subtree inside ()
            res.append("(");
            preorder(root.left, res);
            res.append(")");
        }
        
        //process right
        if(root.right!=null){
            //if right exists and left doesn't then add empty() to maintain the order of child subtree
            if(root.left == null){
                res.append("()");
            }
            //add right subtree inside ()
            res.append("(");
            preorder(root.right, res);
            res.append(")");
        }
    }
}