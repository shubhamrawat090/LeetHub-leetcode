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
    int xKaLeft;
    int xKaRight;
    
    int size(TreeNode root, int x) {
        if(root == null) return 0;
        
        int ls = size(root.left, x);
        int rs = size(root.right, x);
        
        if(root.val == x) {
            xKaLeft = ls;
            xKaRight = rs;
        }
        
        return 1+ls+rs;
    }
    
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        size(root, x);
        
        int otherSide = n - (xKaLeft + xKaRight + 1);
        
        int p2Choice = Math.max(otherSide, Math.max(xKaLeft, xKaRight));
        
        return (p2Choice > n - p2Choice);
    }
}