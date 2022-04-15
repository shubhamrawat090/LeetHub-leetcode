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
    public TreeNode trimBST(TreeNode root, int low, int high) {
        //if tree doesnt exist return null
        if(root == null){
            return null;
        }
        
        //if root.val<low, then all values on the left of root are less than low due to BST property
        //so the answer lies in right side only
        if(root.val<low){
            return trimBST(root.right, low, high);
        }
        //if root.val>high, then all values on the right of root are higher than high due to BST property
        //so the answer lies in left side only
        else if(root.val>high){
            return trimBST(root.left, low, high);
        }
        
        //if root.val is in range, then take root.val and now find answers for its left & right subtree and join them to its left and right
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        
        //return the tree
        return root;
    }
}