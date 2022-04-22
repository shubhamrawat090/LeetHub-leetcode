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
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root == null) {
            return 0;
        }
        
        //initialize sum = 0
        int sum = 0;
        
        //add curr value to sum only if it is inside range
        if(root.val >=low && root.val <= high) {
            sum += root.val;
        }
        
        //we can go to left only if low < root.val as there will be values to explore there
        if(low < root.val)
            sum += rangeSumBST(root.left, low, high);//add the sum derived from left subtree
        
        //we can go to right only if high > root.val as there will be values to explore there
        if(high > root.val)
            sum += rangeSumBST(root.right, low, high);//add the sum derived from right subtree
        
        //return final sum
        return sum;
    }
}