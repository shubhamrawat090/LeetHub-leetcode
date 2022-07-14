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
        HashMap<Integer, Integer> inMap = new HashMap<>();
        for(int i=0; i<inorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        
        return helper(0, preorder.length-1, 0, inorder.length-1, preorder, inorder, inMap);
    }
    
    private TreeNode helper(int preLo, int preHi, int inLo, int inHi, int[] pre, int[] in, HashMap<Integer, Integer> inMap) {
        
        if(preLo > preHi) {
            return null;
        }
        
        TreeNode root = new TreeNode(pre[preLo]);
        
        int inPos = inMap.get(pre[preLo]);
        int elemToLeft = inPos - inLo;
        int elemToRight = inHi - inPos;
        
        root.left = helper(preLo+1, preLo+elemToLeft, inLo, inPos-1, pre, in, inMap);
        root.right = helper(preLo+elemToLeft+1, preHi, inPos+1, inHi, pre, in, inMap);
        
        return root;
    }
}