/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if(original == null) return null;
        if(original == target) {
            return cloned;
        }
        
        TreeNode leftAns = getTargetCopy(original.left, cloned.left, target);
        TreeNode rightAns = getTargetCopy(original.right, cloned.right, target);
        
        if(leftAns != null) return leftAns;
        return rightAns;
    }
}