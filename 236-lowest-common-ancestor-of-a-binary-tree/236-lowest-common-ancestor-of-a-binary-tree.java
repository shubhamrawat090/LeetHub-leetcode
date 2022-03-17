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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            //no node exists
            return null;
        }
        
        if(root == p || root == q){
            //if root is one of the nodes to be found then root is LCA
            return root;
        }
        
        //Get left and right's answers 
        TreeNode leftAns = lowestCommonAncestor(root.left, p, q);
        TreeNode rightAns = lowestCommonAncestor(root.right, p, q);
        
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