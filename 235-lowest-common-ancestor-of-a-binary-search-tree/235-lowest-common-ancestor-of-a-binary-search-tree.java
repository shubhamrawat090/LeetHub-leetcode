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
        //tree doesn't exist
        if(root==null) 
            return null;
        
        //both p and q exist on the right => their LCA will also exist on the right subtree
        if(root.val<p.val && root.val<q.val) 
            return lowestCommonAncestor(root.right,p,q);
        //both p and q exist on the left => their LCA will also exist on the left subtree
        else  if(root.val>p.val && root.val>q.val) 
            return lowestCommonAncestor(root.left,p,q);
        // either of p or q is root which means that is the LCA
        // ROOT IS ALWAYS THE LCA
        return root;
    }
}