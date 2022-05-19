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
    public void recoverTree(TreeNode curr) {
        if(curr == null)
            return;
        
        TreeNode prev=null, first=null, second=null;
        
        //work till curr exists
        while(curr != null) {
            //if left child doesn't exist
            if(curr.left==null) {
                if(prev != null && prev.val>curr.val) {
                    if(first == null){
                        first = prev;
                    }
                    second = curr;
                }
                //print curr and go to right
                prev = curr;
                curr = curr.right;
            } 
            //if left child exists
            else {
                TreeNode iop = curr.left;
                while(iop.right!=null && iop.right!=curr) {
                    iop = iop.right;
                }
                //left is unprocessed
                if(iop.right == null) {
                    //make thread and go to left
                    iop.right = curr;
                    curr = curr.left;
                } 
                //left is processed
                else {
                    if(prev != null && prev.val>curr.val) {
                        if(first == null){
                            first = prev;
                        }
                        second = curr;
                    }
                    //break thread, print and go to right
                    iop.right = null;
                    prev = curr;
                    curr = curr.right;
                }
            }
        }
        
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
}