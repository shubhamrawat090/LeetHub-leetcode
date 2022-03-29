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
    //made tail global as it shouldn't change in recursion calls
    TreeNode tail;
    public TreeNode increasingBST(TreeNode root) {
        if(root == null){
            return null;
        }
        //make dummy node which traverses the tree inorder and makes the required tree
        TreeNode dummy = new TreeNode(0);
        tail = dummy;
        inorder(root);
        
        //return dummy.right as first node was just a dummy
        return dummy.right;
    }
    
    private void inorder(TreeNode root){
        if(root == null){
            return;
        }
        
        inorder(root.left);
        
        //remove cycle
        // root.left = null;
        tail.right = new TreeNode(root.val);
        tail = tail.right;
        
        inorder(root.right);
    }
}