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
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        
        int leftLv = 0;
        TreeNode curr = root;
        while(curr!=null) {
            leftLv++;
            curr = curr.left;
        }
        
        int rightLv = 0;
        curr = root;
        while(curr!=null) {
            rightLv++;
            curr = curr.right;
        }
        
        if(leftLv == rightLv) 
            return (int)Math.pow(2, leftLv) - 1;
        else 
            return 1 + countNodes(root.left) + countNodes(root.right);
    }
}