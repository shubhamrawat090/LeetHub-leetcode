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
    public int sumNumbers(TreeNode root) {
        int sum = helper(root, 0);
        return sum;
    }
    
    public int helper(TreeNode root, int num) {
        if(root == null) {
            return 0;
        }
        
        int sum = 0;
        
        if(root.left == null && root.right == null) {
            num = num*10 + root.val;
            sum += num;
            return sum;
        }
        
        num = num*10 + root.val;
        
        sum += helper(root.left, num);
        sum += helper(root.right, num);
        
        return sum;
    }
}