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
    public TreeNode insertIntoBST(TreeNode node, int data) {
        if(node == null){
          return new TreeNode(data);
        }

        //data exists on left side, so add data somewhere in leftsubtree 
        //and join the newly formed left subtree and join it to node's left side
        if(data<node.val){
          node.left = insertIntoBST(node.left, data);
        }
        //data exists on right side, so add data somewhere in rightsubtree 
        //and join the newly formed right subtree and join it to node's right side
        else if(data>node.val){
          node.right = insertIntoBST(node.right, data);
        }

        //if data already exists then don't add it anywhere

        //after all operation return root
        return node;
    }
}