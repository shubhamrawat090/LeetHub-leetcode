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
    //2 pointers containing the nodes that need to be swapped in order to recover BST
    TreeNode first = null;
    TreeNode second = null;
    //keep prev as low as possible from the range mentioned in constraints
    TreeNode prev = new TreeNode(Integer.MIN_VALUE);
    
    public void recoverTree(TreeNode root) {
        inorder(root);
        
        //swap values of first and second pointer
        int temp = first.val;
        first.val = second.val;
        second.val = temp; 
    }
    
    void inorder(TreeNode root){
        if(root == null){
            return;
        }
        
        inorder(root.left);
        //processing
        
        //            root   3
        //                 /   \
        //                /     \
        // prev(first)   1       4  prev
        //                      /
        //                     /
        //                   2  root(second)
        
        //first node not found & the pair with anomaly found(prev.val>root.val)
        if(first==null && prev.val>root.val){
            //set first pointer as prev
            first = prev;
        }
        
        //first node found now finding second & the pair with anomaly found(prev.val>root.val)
        if(first!=null && prev.val>root.val){
            //set second pointer as root
            second = root;
        }
        
        //after every processing prev is updated as root
        prev = root;
        
        inorder(root.right);
    }
    
    
}