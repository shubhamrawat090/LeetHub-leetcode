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
    public int deepestLeavesSum(TreeNode root) {
        int maxHt = height(root);
        return sumHelper(root, maxHt);
    }
    
    int height(TreeNode root) {
        if(root == null) {
            return 0;
        }
        
        int leftHt = height(root.left);
        int rightHt = height(root.right);
        
        return 1 + Math.max(leftHt, rightHt);
    }
    
    int sumHelper(TreeNode root, int maxHt) {
        if(root == null) {
            return 0;
        }
        
        int sum = 0;
        if(root.left == null && root.right == null && maxHt == 1) {
            sum += root.val;
        }
        
        sum += sumHelper(root.left, maxHt-1);
        sum += sumHelper(root.right, maxHt-1);
        
        return sum;
    }
}