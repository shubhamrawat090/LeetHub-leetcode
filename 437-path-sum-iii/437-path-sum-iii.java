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
    public int pathSum(TreeNode root, int targetSum) {
        int count = dfs(root, targetSum);
        return count;
    }
    
    //consider each node as root and run helper function for it
    public int dfs(TreeNode root, int targetSum) {
        if(root == null) return 0;
        
        int count = 0;
        count += helper(root, targetSum, 0);
        
        count += dfs(root.left, targetSum);
        count += dfs(root.right, targetSum);
        
        return count;
    }
    
    //traverse the tree if at any pt. the sum = target then count it
    private int helper(TreeNode root, int targetSum, int sum) {
        if(root == null) return 0;
        
        int count = 0;
        sum += root.val;
        
        if(targetSum == sum) {
            count++;
        }
        
        count += helper(root.left, targetSum, sum);
        count += helper(root.right, targetSum, sum);
        
        return count;
    }
}