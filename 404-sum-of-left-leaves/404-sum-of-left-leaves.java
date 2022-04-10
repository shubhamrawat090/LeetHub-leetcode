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
    
    public int sumOfLeftLeaves(TreeNode root) {
        //return 0 if no node exists
        if(root == null) return 0;
        
        //calculates sum of left leaf nodes
        int sum = 0;
        
        //if left node exists, then check if it is a leaf or not => add its value to sum if left node is a leaf
        if(root.left!=null && (root.left.left == null && root.left.right == null)){
            sum += root.left.val;
        }
        
        //add the sum of remaining left leaf nodes from left and right subtree
        sum += sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
        
        //return final calculated sum
        return sum;
    }
}