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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        //no tree exist
        if(root == null) return new ArrayList<>();
        
        List<List<Integer>> ans = new ArrayList<>();
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        
        Stack<List<Integer>> stk = new Stack<>();
        List<Integer> levels = new ArrayList<>();
        
        while(q.size()>0){
            
            int count = q.size();
            
            TreeNode curr = q.remove();
            
            if(curr != null) {
                levels.add(curr.val);
                if(curr.left!=null) q.add(curr.left);
                if(curr.right!=null) q.add(curr.right);
            }else {
                if(q.size()>0) q.add(null);
                stk.push(levels);
                levels = new ArrayList<>();
            }
        }
        
        while(stk.size()>0) {
            ans.add(stk.pop());
        }
        
        //return list
        return ans;
    }
}