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
    //counting the cameras
    int count = 0;
    public int minCameraCover(TreeNode root) {
        //0-> camera, 1->monitored, -1->not monitored
        if(helper(root)==-1) {
            //if root is not monitored after putting all cameras, add 1 camera to root
            return count+1;
        }
        //otherwise, the no. of cameras calculated = total cameras required
        return count;
    }
    
    private int helper(TreeNode root) {
        if(root == null) {
            return 1;
        }
        
        //get left and right children's state
        int left = helper(root.left);
        int right = helper(root.right);
        
        //If any side is not monitored
        if(left==-1 || right==-1) {
            //add 1 camera to root
            count++;
            return 0;//return "camera added" to root
        }
        
        //If any side has camera placed
        if(left==0 || right==0) {
            //then we(root) are monitored
            return 1;
        }
        
        //we are unmonitored
        return -1;
    }
}