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
    public int getMinimumDifference(TreeNode root) {
        if(root == null){
            return 0;
        }
        
        List<Integer> increasingList = new ArrayList<>();
        inorder(root, increasingList);
        
        int minDiff = Integer.MAX_VALUE;
        for(int i=0; i<increasingList.size()-1; i++){
            int diff = Math.abs(increasingList.get(i) - increasingList.get(i+1));
            minDiff = Math.min(minDiff, diff);
        }
        
        return minDiff;
    }
    
    private void inorder(TreeNode root, List<Integer> list){
        if(root == null){
            return;
        }
        
        inorder(root.left, list);
        
        list.add(root.val);
        
        inorder(root.right, list);
    }
}