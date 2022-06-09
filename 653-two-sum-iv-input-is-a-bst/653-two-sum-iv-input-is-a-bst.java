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
        return helper(root, root, k);
    }
    
    private boolean helper(TreeNode orig, TreeNode node, int target) {
        if(node == null) {
            return false;
        }
        
        //curr node
        boolean curr = false;
        if(search(orig, node, target-node.val)) {
            curr = true;
        }
        
        boolean left = helper(orig, node.left, target); 
        boolean right = helper(orig, node.right, target);
        
        return curr || left || right;
    }
    
    private boolean search(TreeNode node, TreeNode curr, int val) {
        if(node == null) {
            return false;
        }
        
        if(val < node.val) {
            return search(node.left, curr, val);
        } else if(val > node.val) {
            return search(node.right, curr, val);
        }
        
        return node!=curr;
    }
}