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
        //inorder map: elem -> idx
        for(int i=0; i<inorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        
        return helper(0, preorder.length-1, 0, inorder.length-1, preorder, inMap);
    }
    
    private TreeNode helper(int preLo, int preHi, int inLo, int inHi, int[] pre, HashMap<Integer, Integer> inMap) {
        //out of bounds
        if(preLo > preHi) {
            return null;
        }
        
        //preorder's left most is the root
        TreeNode root = new TreeNode(pre[preLo]);
        
        //get position of curr root in inorder
        int inPos = inMap.get(pre[preLo]);
        
        //get no. of elements in the left & right subtree which will be told by the inorder array as => Left Node Right
        int elemToLeft = inPos - inLo;
        
        //get the left and right subtree of root built by the helper()
        root.left = helper(preLo+1, preLo+elemToLeft, inLo, inPos-1, pre, inMap);
        root.right = helper(preLo+elemToLeft+1, preHi, inPos+1, inHi, pre, inMap);
        
        return root;
    }
}