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
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length-1);
    }
    
    private TreeNode helper(int[] arr, int start, int end){
        if(start > end){
            //just like binary search STOP end start idx exceeds end idx
            return null;
        }
        int mid = start + (end - start)/2;
        
        TreeNode root = new TreeNode(arr[mid]);//root is the middle value of sorted arr
        
        //faith-> get BST converted for left subtree
        root.left = helper(arr, start, mid-1);
        
        //faith-> get BST converted for right subtree
        root.right = helper(arr, mid+1, end);
        
        return root;
    }
}