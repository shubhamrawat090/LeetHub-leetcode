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
    private int deepestSum = 0;
    private int deepestLevel = 0;

    public int deepestLeavesSum(TreeNode root) { 
        traverse(root, 0);
        return deepestSum;
    }

    private void traverse(TreeNode root, int level) {
        if(root == null) {
            return;
        }

        if(root.left == null && root.right == null) {
            //if leaf node reached and current level is the deepest
            if(deepestLevel == level) {
                deepestSum += root.val;
            }
            //finding deepest level
            else if(deepestLevel < level){
                deepestSum = root.val;
                deepestLevel = level;
            } 
        }
        
        //go to left and right subtree
        traverse(root.left, level+1);
        traverse(root.right, level+1);
    }
}