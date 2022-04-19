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
    public void recoverTree(TreeNode root) {
        
        /// USING MORRIS INORDER TRAVERSAL
        
        if(root == null) return;
        
        TreeNode prev = null;
        TreeNode first = null;
        TreeNode second = null;
        
        while(root!=null){
            if(root.left == null){
                // PROCESSING NODE
                if(prev!=null && prev.val>root.val){
                    //first not found
                    if(first==null){
                        first = prev;
                    }
                    
                    second = root;
                }
                
                prev = root;
                
                root = root.right;
            }else{
                //get a ptr to right most of left node
                TreeNode temp = root.left;
                while(temp.right != null && temp.right != root){
                    temp = temp.right;
                }
                
                //join temp to root to create threaded binary tree
                if(temp.right == null){
                    temp.right = root;
                    root = root.left;
                }else{
                    temp.right = null;
                    
                    // PROCESSING NODE
                    if(prev!=null && prev.val>root.val){
                        //first not found
                        if(first==null){
                            first = prev;
                        }

                        second = root;
                    }

                    prev = root;
                    
                    root = root.right;
                }
            }
        }
        
        //Swap first and second ptr values
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
        
    }
}