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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) {
            return null;
        }
        
        if(key>root.val) {
            root.right = deleteNode(root.right, key);
        } else if(key<root.val) {
            root.left = deleteNode(root.left, key);
        }
        
        if(root.val == key) {
            if(root.left != null && root.right != null) {
                //both children
                //get right min
                int min = getMin(root.right);
                root.val = min;//set data
                root.right = deleteNode(root.right, min);//delete that min node in right subtree
            }
            
            //1 child
            else if(root.right != null) {
                return root.right;
            }
            else if(root.left != null) {
                return root.left;
            }
            //no child-> leaf node
            else {
                return null;
            }
            
        }
        
        return root;
    }
    
    private int getMin(TreeNode root) {
        while(root.left!=null) {
            root = root.left;
        }
        
        return root.val;
    }
}