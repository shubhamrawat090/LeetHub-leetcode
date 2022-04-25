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
        // root.val == min(root.left.val, root.right.val) for each internal node of the tree.
        // due to this constraint root value is the least so we have to find any minimum greater than this
        dfs(root, root.val);
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
            res = Math.min(res, root.val);//find min b/w val>lowest value and our res
        }
        
        //process left and right subtree
        dfs(root.left, min);
        dfs(root.right, min);
    }
}