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
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if(root == null){
            return null;
        }
        
        //check for left and right subtrees
        if(root.left == null && root.right == null && root.val == target){
            return null;
        }
        
        //faith -> left and right subtree are solved 
        TreeNode left = removeLeafNodes(root.left, target);
        TreeNode right = removeLeafNodes(root.right, target);
        
        //join left and right computed to root
        root.left = left;
        root.right = right;
        
        //after checking for subtrees check if after deleting required node our root has become the required node or not
        if(root.left == null && root.right == null && root.val == target){
            return null;
        }
        
        //return root
        return root;
    }
}