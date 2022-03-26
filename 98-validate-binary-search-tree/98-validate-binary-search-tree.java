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
    Integer prev = null;
    public boolean isValidBST(TreeNode root) {
        //if no nodes exists it is said to be a BST
        if(root == null){
            return true;
        }
        
        //PROCESSING IS DONE IN-ORDER
        //check if left subtree is valid BST
        boolean left = isValidBST(root.left);
        
        //if prev value exists and is higher that root then it is not a BST 
        //as in a BST the inorder is in increasing order
        if(prev!=null && root.val<=prev){
            return false;//return false as it is not a BST
        }else{
            //set prev to curr node
            prev = root.val;
        }
        
        //check if the right subtree is BST
        boolean right = isValidBST(root.right);
        
        //check if both left and right are BST
        return left && right;
    }
}