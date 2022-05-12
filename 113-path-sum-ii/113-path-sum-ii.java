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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        
        helper(root, targetSum, res, path);
        
        return res;
    }
    
    private void helper(TreeNode root, int target, List<List<Integer>> res, List<Integer> path) {
        if(root == null) return;
        
        path.add(root.val);
            
        if(root.left == null && root.right == null) {
            if(root.val == target) {
                res.add(new ArrayList<>(path));
            }
        } else {
            helper(root.left, target-root.val, res, path);
            helper(root.right, target-root.val, res, path);
        }
        
        path.remove(path.size()-1);
    }
}