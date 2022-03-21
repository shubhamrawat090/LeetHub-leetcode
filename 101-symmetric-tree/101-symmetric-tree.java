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
    public boolean isSymmetric(TreeNode root) {
        //if tree with no element is also symmetrical
        if(root == null) return true;
        
        // OBSERVATION: if we consider left subtree and right subtree as 2 different trees, then if both the trees are same(but leftSubTree.right = rightSubTree.left & vice versa) that means our entire tree is Symmetrical
        return isSameTree(root.left, root.right); 
    }
    
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if((p == null && q != null) || (q == null && p != null)) return false;
        
        if(p == null && q == null) return true;
        
        // if(p.val!=q.val) return false;
            
        //check leftSubtree.left = rightSubtree.right
        boolean leftAns = isSameTree(p.left, q.right);
        
        //check leftSubtree.right = rightSubtree.left
        boolean rightAns = isSameTree(p.right, q.left);
        
        //both ans should be true
        if(leftAns && rightAns && (p.val==q.val)) return true;
        
        //one of the ans is false then tree is not symmetrical
        return false;
    }
}