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
    int res=Integer.MAX_VALUE;
    boolean flag=false;
    
    public int findSecondMinimumValue(TreeNode root) {
        dfs(root, root.val);//first value considered minimum
        return (flag == true) ? res : -1;
    }
    public void dfs(TreeNode root,int min){
        if(root==null){
            //do nothing
            return;
        }
        
        //if any value > min then we have found atleast 2 distince values => 2nd min can be found
        if(root.val>min){
            flag = true;//2nd min possible
            res = Math.min(res, root.val);
        }
        
        dfs(root.left, min);
        dfs(root.right, min);
    }
}