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
    public boolean isValidBST(TreeNode root) {
        Integer prev = null;
        
        while(root!=null) {
            if(root.left==null) {
                //print
                if(prev!=null && prev>=root.val) {
                    return false;
                }
                prev=root.val;
                //go to right
                root=root.right;
            } else {
                //find inorder predecessor
                TreeNode iop = root.left;
                while(iop.right!=null && iop.right!=root) {
                    iop=iop.right;
                }
                //if left is unprocessed
                if(iop.right==null) {
                    //make thread
                    iop.right=root;
                    root=root.left;//go to left
                } else {
                    //break thread
                    iop.right=null;
                    //print
                    if(prev!=null && prev>=root.val) {
                        return false;
                    }
                    prev=root.val;
                    //go to right
                    root=root.right;
                }
            }
        }
        
        return true;
    }
}