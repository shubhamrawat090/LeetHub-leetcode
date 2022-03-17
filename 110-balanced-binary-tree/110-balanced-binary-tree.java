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
    class Pair{
        int height;
        boolean balanced;
        
        Pair(){
            this.height = 0;
            this.balanced = false;
        }
        Pair(int height, boolean balanced){
            this.height = height;
            this.balanced = balanced;
        }
    }
    
    public boolean isBalanced(TreeNode root) {
        return heightBalancedChecker(root).balanced;
    }
    
    Pair heightBalancedChecker(TreeNode node){
        if(node == null)
            return new Pair(0, true);
        
        Pair leftPair = heightBalancedChecker(node.left);
        if(!leftPair.balanced){
            return leftPair;
        }
        Pair rightPair = heightBalancedChecker(node.right);
        if(!rightPair.balanced){
            return rightPair;
        }
        
        int htDiff = Math.abs(leftPair.height - rightPair.height);
        Pair ans = new Pair();
        ans.height = 1 + Math.max(leftPair.height, rightPair.height);
        if(htDiff<=1){
            ans.balanced = true;
        }else{
            ans.balanced = false;
        }
        
        return ans;
    }
}