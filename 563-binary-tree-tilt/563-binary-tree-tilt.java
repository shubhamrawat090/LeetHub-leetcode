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
    private int tilt = 0;
    
    public int findTilt(TreeNode root) {
        findTiltSum(root);
        return tilt;
    }
    
    private int findTiltSum(TreeNode node) {
        if(node == null) {
            return 0;
        }
        int leftTilt = findTiltSum(node.left);
        int rightTilt = findTiltSum(node.right);
        tilt += Math.abs(leftTilt - rightTilt);
        return leftTilt + rightTilt + node.val;
    }
}