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
        //root is sent 2 times because 1 of them is the root of original tree as we have to start searching in the original tree and not the root of the subtree in different recursive function calls
        return targetSumPair(root, root, k);
    }
    
    //for every node search its complement(targetSum - node.data) in the entire tree
    //time O(NlogN) => traversing each node * searching in entire tree
    public boolean targetSumPair(TreeNode node, TreeNode originalRoot, int targetSum){
        if(node == null){
          return false;
        }

        //get ans from left subtree if there is a pair available
        boolean left = targetSumPair(node.left, originalRoot, targetSum);

        //complement of our root's value
        int complement = targetSum - node.val;
        //only pairs allowed are (a,b) where a<b, a = root.val, b = complement of root.val
        if(complement>node.val){
          if(search(originalRoot, complement)==true)
            return true;
        }

        //get ans from left subtree if there is a pair available
        boolean right = targetSumPair(node.right, originalRoot, targetSum);
        
        //return true if either of the ans is true which means we have found atleast 1 pair
        return right || left;
    } 
    
      
      // function to search in the entire tree
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