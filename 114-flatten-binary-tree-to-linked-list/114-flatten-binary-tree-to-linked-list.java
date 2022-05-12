class Solution {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        traverse0(root);
    }
    
    // return end of "linked-list"
    private TreeNode traverse0(TreeNode root) {
        if (root == null) {
            return null;
        }
        
        //storing left and right subtree in temporary nodes
        TreeNode left = root.left;
        TreeNode right = root.right;
        
        //make left side null
        root.left = null;
        
        //go to end of left subtree and flatten it
        TreeNode leftEnd = traverse0(left);
        
        //if there is end of left node
        //add left tree to right-side of root
        //to the end of left subtree add right subtree
        if (leftEnd != null) {
            root.right = left;
            leftEnd.right = right;
        }
        
        //go to right subtree and flatten it
        TreeNode rightEnd = traverse0(right);
        
        //if rightEnd doesn't exist
        if (rightEnd == null) {
            //if left tree's end == null, return the tree otherwise return the leftEnd
            return leftEnd == null ? root : leftEnd;
        } 
        //if rightEnd exists return it
        else {
            return rightEnd;
        }
    }
}