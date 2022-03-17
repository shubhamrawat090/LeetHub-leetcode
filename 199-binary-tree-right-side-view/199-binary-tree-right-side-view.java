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
    List<Integer> res = new ArrayList<>();
    int maxDepth = -1;
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return res;
        helper(root, 0);
        return res;
    }
    public void helper(TreeNode node, int depth) {
        if (node == null) {
            return;
        }
        if (depth > maxDepth) {
            res.add(node.val);
        }
        maxDepth = Math.max(maxDepth, depth);
        helper(node.right, depth+1);
        helper(node.left, depth+1);

    }
}