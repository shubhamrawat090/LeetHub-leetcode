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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return new ArrayList<>();
        
        //list containing all nodes levelwise
        List<List<Integer>> ans = new ArrayList<>();
        
        //queue for processing
        Queue<TreeNode> q = new ArrayDeque<>();
        
        //add root to queue
        q.add(root);
        
        //work till queue is empty
        while(!q.isEmpty()){
            //currently queue contains nodes of a particular so do this size no. of times
            int count = q.size();
            
            //list for nodes of current level
            List<Integer> levels = new ArrayList<>();
            
            while(count-- > 0){
                //remove front node of queue as it contains first node of that level from left -> right
                TreeNode curr = q.remove();
                //add that value to levels list
                levels.add(curr.val);
                
                //get the left child of current tree if it exists
                if(curr.left!=null) q.add(curr.left);
                //get the right child of current tree if it exists
                if(curr.right!=null) q.add(curr.right);
            }
            
            //add that level to our ans
            ans.add(levels);
        }
        
        return ans;
    }
}