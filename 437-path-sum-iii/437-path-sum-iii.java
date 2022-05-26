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
    int count = 0;
    public int pathSum(TreeNode root, int targetSum) {
        dfs(root, targetSum);
        return count;
    }
    
    public void dfs(TreeNode root, int targetSum) {
        if(root == null) return;
        
        helper(root, targetSum, 0);
        
        dfs(root.left, targetSum);
        dfs(root.right, targetSum);
    }
    
    private void helper(TreeNode root, int targetSum, int sum) {
        if(root == null) return;
        
        sum += root.val;
        
        if(targetSum == sum) {
            count++;
        }
        
        helper(root.left, targetSum, sum);
        helper(root.right, targetSum, sum);
    }
}