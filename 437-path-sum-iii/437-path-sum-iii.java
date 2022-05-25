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
    int count = 0;
    public int pathSum(TreeNode root, int targetSum) {
        HashMap<Integer, Integer> map = new HashMap();
        map.put(0, 1);
        helper(root, targetSum, 0, map);
        return count;
    }
    
    public void helper(TreeNode root, int target, int sum, HashMap<Integer, Integer> map) {
        if(root == null) return;
        
        sum = sum+root.val;
        if(map.containsKey(sum-target)) {
            count += map.get(sum-target);
        } 
        
        if(map.containsKey(sum)) {
            map.put(sum, map.get(sum)+1);
        }else {
            map.put(sum, 1);
        }
        
        helper(root.left, target, sum, map);
        helper(root.right, target, sum, map);
        
        if(map.get(sum) == 1) {
            map.remove(sum);
        }else {
            map.put(sum, map.get(sum)-1);
        }
        
    }
}