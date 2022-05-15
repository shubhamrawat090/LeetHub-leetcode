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
    //stores total sum of all the values required
    int totalSum = 0;
    public int sumNumbers(TreeNode root) {
        //dfs function traversing tree
        helper(root, 0);
        return totalSum;
    }
    
    //dfs helper function
    private void helper(TreeNode root, int sum) {
        //don't do anything if node doesn't exist
        if(root == null) return;
        
        //when leaf node reached
        if(root.left == null && root.right == null) {
            //convert the sum into number
            totalSum += (sum*10) + root.val;
            return;
        }
        //previous value * 10 + curr val = number you want
        sum = sum*10;
        helper(root.left, sum + root.val);
        helper(root.right, sum + root.val);
        
        return;
    }
}