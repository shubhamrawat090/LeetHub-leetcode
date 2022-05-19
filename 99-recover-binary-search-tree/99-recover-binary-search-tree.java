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
    TreeNode prev=null, first=null, second=null;
    public void recoverTree(TreeNode curr) {
        if(curr == null)
            return;
        
        inorder(curr);
        
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
    
    void inorder(TreeNode curr) {
        if(curr == null) return;
        
        inorder(curr.left);
        if(prev!=null) {
            if(prev.val>curr.val) {
                if(first==null) first = prev;
                second = curr;
            }
        }
        
        prev = curr;
        inorder(curr.right);
    }
}