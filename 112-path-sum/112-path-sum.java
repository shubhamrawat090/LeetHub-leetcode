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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        //if no node exists return false
        if(root == null) return false;
        
        //if leaf node is encountered, check that current node's value is equal to targetSum as targetSum has been reduced by node.val at each node before it and if our curr node's value matches targetSum it means targetSum reduced to 0
        //Our motive is to traverse to each node till we encounter leaf node and reduce targetSum by node.val till it becomes zero
        if(root.left == null && root.right == null){
            return root.val == targetSum;
        }
        
        //reduce targetSum by curr node's val and check left and right subtree if either of them can reduce our targetSum exactly to zero
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }
}