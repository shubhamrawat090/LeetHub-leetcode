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
        
        boolean left = helper(orig, node.left, target);
        
        //curr node
        if(target-node.val>node.val) {
            if(search(orig, target-node.val)) {
                return true;
            }
        }
        
        boolean right = helper(orig, node.right, target);
        
        return left || right;
    }
    
    private boolean search(TreeNode node, int val) {
        if(node == null) {
            return false;
        }
        
        if(node.val == val) {
            return true;
        }
        
        if(val < node.val) {
            return search(node.left, val);
        } else {
            return search(node.right, val);
        }
    }
}