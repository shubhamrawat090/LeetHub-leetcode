/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    boolean f1 = false;
    boolean f2 = false;
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode ans = helper(root, p, q);
        
        if(f1 == true && f2 == true) {
            return ans;
        } else {
            return null;
        }
    }
    
    private TreeNode helper(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            //no node exists
            return null;
        }
        
        //Get left and right's answers 
        TreeNode leftAns = helper(root.left, p, q);
        TreeNode rightAns = helper(root.right, p, q);
        
        //if root is one of the nodes to be found then root is LCA
        if(root == p){
            f1 = true;
            return root;
        }
        
        if(root == q){
            f2 = true;
            return root;
        }
        
        if(leftAns!=null && rightAns!=null){
            //if left and right have p & q in them then root is LCA
            return root;
        }else if(rightAns==null){
            //p & q both are present in left tree, then left child is the LCA
            return leftAns;
        }
        
        //p & q both are present in right tree, then right child is the LCA
        return rightAns;
    }
}