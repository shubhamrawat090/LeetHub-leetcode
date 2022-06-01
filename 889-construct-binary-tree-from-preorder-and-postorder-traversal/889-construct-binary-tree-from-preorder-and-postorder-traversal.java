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
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        //map to search in postorder
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i=0; i<postorder.length; i++) {
            map.put(postorder[i], i);
        }
        
        TreeNode root = helper(preorder, postorder, map, 0, preorder.length-1, 0, postorder.length-1);
        return root;
    }
    
    private TreeNode helper(int[] pre, int[] post, HashMap<Integer, Integer> map, int preLo, int preHi, int postLo, int postHi) {
        if(preLo>preHi || postLo>postHi) {
            return null;
        }
        
        TreeNode node = new TreeNode(pre[preLo]);
        
        if(preLo+1<=preHi) {
            int sidx = map.get(pre[preLo+1]);
            int lhs = sidx - postLo + 1;
            
            node.left = helper(pre, post, map, preLo+1, preLo+lhs, postLo, sidx);
            node.right = helper(pre, post, map, preLo+lhs+1, preHi, sidx+1, postHi-1);
        }
        
        return node;
    }
}