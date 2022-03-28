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
    private int max(TreeNode root){
        if(root.right!=null){
            return max(root.right);
        }else{
            return root.val;
        }
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null){
            return null;
        }
        
        if(key<root.val){
            root.left = deleteNode(root.left, key);
        }else if(key>root.val){
            root.right = deleteNode(root.right, key);
        }else{
            //case 1: no children i.e. leaf node
            if(root.right == null && root.left == null){
                return null;
            }
            
            //case 2: 1 child either left or right
            if(root.left == null){
                return root.right;
            }
            if(root.right == null){
                return root.left;
            }
            
            //case 3: two children
            else{
                int justSmaller = max(root.left);
                root.val = justSmaller;
                root.left = deleteNode(root.left, justSmaller);
            }
        }
        
        return root;
    }
}