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
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        //if tree 1 has no node then return tree 2's node
        if(root1 == null){
            return root2;
        }
        //if tree 2 has no node then return tree 1's node
        if(root2 == null){
            return root1;
        }
        
        //make a dummy node and add both tree values sum in it's root
        TreeNode dummy = new TreeNode(root1.val + root2.val);
        //left child will have the merged tree from left subtrees of root1 and root2
        dummy.left = mergeTrees(root1.left, root2.left);
        //right child will have the merged tree from right subtrees of root1 and root2
        dummy.right = mergeTrees(root1.right, root2.right);
        
        //return our dummy
        return dummy;
    }
}