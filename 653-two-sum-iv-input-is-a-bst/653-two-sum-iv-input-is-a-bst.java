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
    public boolean findTarget(TreeNode root, int k) {
        return targetSumPair(root, root, k);
    }
    
    public boolean targetSumPair(TreeNode node, TreeNode originalRoot, int targetSum){
        if(node == null){
          return false;
        }

        boolean left = targetSumPair(node.left, originalRoot, targetSum);

        int complement = targetSum - node.val;
        if(complement>node.val){
          if(search(originalRoot, complement)==true)
            return true;
        }

        boolean right = targetSumPair(node.right, originalRoot, targetSum);
        
        return right || left;
      } 

  public boolean search(TreeNode node, int target){
    if(node == null){
      return false;
    }

    if(node.val == target){
      return true;
    }

    if(target<node.val){
      return search(node.left, target);
    }else{
      return search(node.right, target);
    }
  }
}