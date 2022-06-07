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
    int i=0;
    public TreeNode recoverFromPreorder(String traversal) {
        return helper(traversal, 0);
    }
    
    private TreeNode helper(String str, int depth) {
        int dash = 0;
        
        while(i+dash<str.length() && str.charAt(i+dash)=='-') {
            dash++;
        }
        
        if(dash!=depth) {
            return null;
        }
        
        int nonDash = 0;
        
        while(i+dash+nonDash<str.length() && str.charAt(i+dash+nonDash)!='-') {
            nonDash++;
        }
        
        int val = Integer.parseInt(str.substring(i+dash, i+dash+nonDash));
        
        i = i+dash+nonDash;
        
        TreeNode node = new TreeNode(val);
        
        node.left = helper(str, depth+1);
        node.right = helper(str, depth+1);
        
        return node;
    }
}