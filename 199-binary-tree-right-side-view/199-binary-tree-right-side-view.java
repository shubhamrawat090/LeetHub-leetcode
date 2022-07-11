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
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null) {
            return new ArrayList<>();
        }
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        
        List<Integer> rightView = new ArrayList<>();
        
        while(q.size()>0) {
            int size = q.size();
            for(int i=1; i<=size; i++) {
                TreeNode top = q.remove();
                
                if(i == size) {
                    rightView.add(top.val);
                }
                
                if(top.left!=null) {
                    q.add(top.left);
                }
                
                if(top.right!=null) {
                    q.add(top.right);
                }
            }
        }
        
        return rightView;
    }
}