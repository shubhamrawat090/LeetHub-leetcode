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
        
        //dfs helper function
        helper(root, targetSum, res, path);
        
        return res;
    }
    
    private void helper(TreeNode root, int target, List<List<Integer>> res, List<Integer> path) {
        if(root == null) return;
        //add root to path
        path.add(root.val);
            
        //if root is leaf node and its value is target left then add that path to resultant
        if(root.left == null && root.right == null && root.val == target) {
            res.add(new ArrayList<>(path));
        } 
        //work for left and right subtrees
        else {
            helper(root.left, target-root.val, res, path);
            helper(root.right, target-root.val, res, path);
        }
        
        //backtrack
        path.remove(path.size()-1);
    }
}