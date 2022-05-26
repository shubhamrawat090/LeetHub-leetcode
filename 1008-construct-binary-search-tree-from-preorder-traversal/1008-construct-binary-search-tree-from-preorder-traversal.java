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
    //keeps incrementing globally
    int idx = 0;
    public TreeNode bstFromPreorder(int[] preorder) {
        //construct a tree with upper and lower bound for current node value
        return construct(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    //helper function to construct the BST
    private TreeNode construct(int[] pre, int min, int max) {
        //all elements are processed and tree is completed
        if(idx == pre.length) return null;
        
        //if the element is within range of min,max
        else if(pre[idx]>min && pre[idx]<max) {
            //create a new node and add its value
            TreeNode node = new TreeNode();
            node.val = pre[idx];
            idx++;//increment the idx as you have used this value
            
            //construct left and right subtree with next value and limits changes and add it using our node as root
            node.left = construct(pre, min, node.val);
            node.right = construct(pre, node.val, max);
            //return that node
            return node;
        } else {
            //for any other case just return null
            return null;
        }
    }
}