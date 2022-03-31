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
    public TreeNode convertBST(TreeNode root) {
        if(root == null){
            return root;
        }
        
        //traverse reverse inorder(Right Node Left) -> Decreasing order, and store sum in golbal varaible
        reverseInorder(root);
        //return newly changed tree
        return root;
    }
    
    //global var that store sum of all greater value nodes + our value
    int sum = 0;
    void reverseInorder(TreeNode root){
        //no need to check it as we have check it in above function
        if(root == null) return;
        
        //////////////// RIGHT call ////////////////
        reverseInorder(root.right);
        
        //////////////// NODE work ////////////////
        
        //store current root's value in previously calculated sum as sum = previous sum(sum of all greater val nodes) + our sum
        sum += root.val;
        root.val = sum;//set our value as this sum
        
        //////////////// LEFT call ////////////////
        reverseInorder(root.left);
    }
}