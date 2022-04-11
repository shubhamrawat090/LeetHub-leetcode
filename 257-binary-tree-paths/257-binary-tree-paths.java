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
    public List<String> binaryTreePaths(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        
        if(root.left == null && root.right == null){
            List<String> ans = new ArrayList<>();
            ans.add(Integer.toString(root.val));
            return ans;
        }
        
        List<String> left = binaryTreePaths(root.left);
        List<String> right = binaryTreePaths(root.right);
        
        List<String> ans = new ArrayList<>();
        
        for(String val: left){
            ans.add(root.val+"->"+val);
        }
        
        for(String val: right){
            ans.add(root.val+"->"+val);
        }
        
        return ans;
    }
}