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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        //if both trees and empty that means they are equal
        if(p == null && q == null) return true;
        
        //if one is empty and other isn't, they aren't equal
        if((p == null && q != null) || (q == null && p != null)) return false;
        
        //getting ans for left subtrees of both trees
        boolean leftAns = isSameTree(p.left, q.left);
        
        //getting ans for right subtrees of both trees
        boolean rightAns = isSameTree(p.right, q.right);
        
        //if leftAns=true && rightAns=true && root values of both trees match then it means, they both are equal
        if(leftAns && rightAns && (p.val == q.val)) return true;
        
        //Otherwise, the two trees aren't equal
        return false;
    }
}