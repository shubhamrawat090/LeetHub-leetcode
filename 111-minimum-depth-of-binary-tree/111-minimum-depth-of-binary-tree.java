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
    public int minDepth(TreeNode root) {
        //no tree exist
        if(root == null) return 0;
        
        //initially depth 1
        int level = 1;
        
        //helper queue 
        Queue<TreeNode> q = new ArrayDeque<>();
        
        //add root to queue
        q.add(root);
        
        while(q.size()>0){
            //q size can vary when we are removing inside the loop so we don't know how many times the for loop runs which is why we store it in a variable count
            int count = q.size();
            
            //all count(size of queue after pushing nodes) no. of nodes are nodes at a particular level
            while(count-->0){
                //take curr node from queue
                TreeNode curr = q.remove();
                
                //if a leaf node is spotted then return that depth
                if(curr.left==null && curr.right==null) return level;
                //add left and right nodes in queue if they exist
                if(curr.left!=null) q.add(curr.left);
                if(curr.right!=null) q.add(curr.right);
            }
            
            //go to next level
            level++;
        }
        
        return level;
    }
}