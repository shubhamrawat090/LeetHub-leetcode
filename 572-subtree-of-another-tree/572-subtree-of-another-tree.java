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
    public boolean sameTree(TreeNode nodeA, TreeNode nodeB){
        if(nodeA == null && nodeB == null){
            return true;
        }
        
        if(nodeA == null || nodeB == null){
            return false;
        }
        
        if(nodeA.val != nodeB.val){
            return false;
        }
        
        return sameTree(nodeA.right, nodeB.right) && sameTree(nodeA.left, nodeB.left);
    }
    
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null && subRoot == null){
            return true;
        }
        
        if(root == null || subRoot == null){
            return false;
        }
        
        boolean ans = false;
        
        if(root.val == subRoot.val){
            ans = sameTree(root, subRoot);
        }
        
        return ans || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
}