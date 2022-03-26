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
    //global variable for storing the best diameter of all nodes
    int diameter = 0;
    
    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return diameter;
    }
    
    //calculates height but also stores the diameter of all nodes
    public int height(TreeNode root){
        if(root == null){
            return -1;
        }
        
        //left child height
        int lh = height(root.left);
        //right child height
        int rh = height(root.right);

        //current node's diameter
        int myDia = lh + rh + 2;
        //comparing our current diameter with the best diameter so far
        diameter = Math.max(diameter, myDia);
        
        //returning height of current node
        return Math.max(lh, rh) + 1;
    }
}