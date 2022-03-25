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
    static int maxPathSum;
    public int pathSum(TreeNode root) {
        if(root == null){
            return 0;
        }
        
        int leftAns = pathSum(root.left);
        int rightAns = pathSum(root.right);
        int leftWithRoot = leftAns + root.val;
        int rightWithRoot = rightAns + root.val;
        int leftRightRoot = leftAns + rightAns + root.val;
        maxPathSum = Math.max(maxPathSum, Math.max(root.val, Math.max(leftRightRoot, Math.max(leftWithRoot, rightWithRoot))));
        
        return Math.max(root.val, Math.max(rightWithRoot, leftWithRoot));
    }
    
    public int maxPathSum(TreeNode root) {
        maxPathSum = Integer.MIN_VALUE;
        pathSum(root);
        return maxPathSum;
    }
}