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
    public TreeNode searchBST(TreeNode root, int val) {
        if(root==null){
            return null;
        }
        
        //target found at root
        if(root.val == val){
            return root;
        }
        //target exists in left subtree, find it and return it
        else if(val<root.val){
            return searchBST(root.left, val);
        }
        
        //target exists in right subtree, find it and return it
        return searchBST(root.right, val);
    }
}