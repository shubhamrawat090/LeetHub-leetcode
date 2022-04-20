class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null) return false;
        return matchSubtree(root, subRoot) // if this matches below two recursions won't execute
            || isSubtree(root.left, subRoot)
            || isSubtree(root.right, subRoot);
    }
    
    boolean matchSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null && subRoot == null) return true;
        if(root == null || subRoot == null) return false;
        if(root.val != subRoot.val) return false;
        return matchSubtree(root.left, subRoot.left)
                && matchSubtree(root.right, subRoot.right);
    }
}