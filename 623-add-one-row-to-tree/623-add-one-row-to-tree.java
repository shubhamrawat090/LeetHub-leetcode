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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth == 1){
            //if depth = 1 mentioned it means make a node with val and add root to its left side
            return new TreeNode(val, root, null);
        }
        
        if(depth == 2){
            //for depth = 2, make a tree with val as root and add curr root's left subtree to its left
            TreeNode leftTree = new TreeNode(val, root.left, null);
            //add this new left tree to our current root's left side
            root.left = leftTree;
            //make a tree with val as root and add curr root's right subtree to its right
            TreeNode rightTree = new TreeNode(val, null, root.right);
            //add this new right tree to our current root's right side
            root.right = rightTree;
        }
        
        //go to left if left exists
        if(root.left!=null){
            addOneRow(root.left, val, depth-1);
        }
        //go to right if right exists
        if(root.right!=null){
            addOneRow(root.right, val, depth-1);
        }
        
        //return the tree after changes
        return root;
    }
}