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
    public int pathSum(TreeNode root, int targetSum) {
        //stores currSum -> occurrence of curr sum
        HashMap<Integer, Integer> map = new HashMap();
        //sum = 0 occurred 1 time
        map.put(0, 1);
        return helper(root, targetSum, 0, map);
    }
    
    public int helper(TreeNode root, int target, int sum, HashMap<Integer, Integer> map) {
        if(root == null) return 0;
        
        //add root.val to our curr sum
        sum = sum+root.val;
        int count = 0;
        //if sum-target exists in map then we have caught some path = target
        if(map.containsKey(sum-target)) {
            count += map.get(sum-target);
        } 
        
        //if the sum is occurred already => increment it
        if(map.containsKey(sum)) {
            map.put(sum, map.get(sum)+1);
        }
        //otherwise, occurred 1st time
        else {
            map.put(sum, 1);
        }
        
        count += helper(root.left, target, sum, map);
        count += helper(root.right, target, sum, map);
        
        //backtrack
        if(map.get(sum) == 1) {
            map.remove(sum);
        }else {
            map.put(sum, map.get(sum)-1);
        } 
        
        return count;
    }
}