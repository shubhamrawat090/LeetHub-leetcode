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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> inordMap = new HashMap();
        for(int i=0; i<inorder.length; i++) {
            int val = inorder[i];
            inordMap.put(val, i);
        }
        TreeNode root = construct(0, preorder.length-1, 0, inorder.length-1, preorder, inordMap);
        return root;
    }
    
    private TreeNode construct(int pre_lo, int pre_hi, int in_lo, int in_hi, int[] pre, HashMap<Integer, Integer> inordMap) {
        //base case
        if(pre_lo > pre_hi || in_lo > in_hi) {
            return null;
        }
        
        TreeNode node = new TreeNode();
        
        node.val = pre[pre_lo];
        
        int idx = inordMap.getOrDefault(pre[pre_lo], 0);
        
        int lhs = idx - in_lo;
        
        node.left = construct(pre_lo+1, pre_lo+lhs, in_lo, idx-1, pre, inordMap);
        node.right = construct(pre_lo+lhs+1, pre_hi, idx+1, in_hi, pre, inordMap);
        
        return node;
    }
}