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
    //global variable that holds out ans
    static int maxPathSum;
    //helper function which checks at every root for maxPathSum and stores max of all values in global var
    public int pathSum(TreeNode root) {
        //if no nodes then 0 is our ans
        if(root == null){
            return 0;
        }
        
        //get ans for left subtree
        int leftAns = pathSum(root.left);
        //get ans for right subtree
        int rightAns = pathSum(root.right);
        //get ans for left subtree + root
        int leftWithRoot = leftAns + root.val;
        //get ans for right subtree + root
        int rightWithRoot = rightAns + root.val;
        //get ans for both subtrees and root i.e. entire tree
        int leftRightRoot = leftAns + rightAns + root.val;
        //maximum of previous value, just root, entire tree, left subtree with root and right subtree with root
        maxPathSum = Math.max(maxPathSum, Math.max(root.val, Math.max(leftRightRoot, Math.max(leftWithRoot, rightWithRoot))));
        
        //our function gives the best from just root, left subtree including root and right subtree including root
        return Math.max(root.val, Math.max(rightWithRoot, leftWithRoot));
    }
    
    //this is the driver function
    public int maxPathSum(TreeNode root) {
        //initially path value is set to -infinity as path can be negative
        maxPathSum = Integer.MIN_VALUE;
        //pass our tree to helper function
        pathSum(root);
        //return the maxPathSum calculated by the helper function
        return maxPathSum;
    }
}