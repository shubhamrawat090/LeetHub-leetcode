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
    public TreeNode balanceBST(TreeNode root) {
        if(root == null || (root.left==null && root.right==null)) {
            return root;
        }
        //store values in arraylist - inorder - increasing order
        ArrayList<Integer> values = new ArrayList<>();
        traverse(root, values);
        //construct a balanced tree with those values
        return construct(0, values.size()-1, values);
    }
    
    private TreeNode construct(int start, int end, ArrayList<Integer> values) {
        if(start > end) return null;
        
        //mid as root
        int mid = start+(end-start)/2;
        TreeNode root = new TreeNode(values.get(mid));
        //start to mid-1 is left subtree
        root.left = construct(start, mid-1, values);
        //mid+1 to end is left subtree
        root.right = construct(mid+1, end, values);
        
        return root;
    }
    
    //morris traversal - inorder
    private void traverse(TreeNode root, ArrayList<Integer> values) {
        
        while(root != null) {
            if(root.left == null) {
                //print 
                values.add(root.val);
                //go to right
                root = root.right;
            } else {
                //find inorder predecessor
                TreeNode iop = root.left;
                while(iop.right != null && iop.right != root) {
                    iop = iop.right;
                }
                //if left side is unprocessed
                if(iop.right == null) {
                    //make thread
                    iop.right = root;
                    //go to left
                    root = root.left;
                }
                //if left side is processed
                else {
                    //break thread
                    iop.right = null;
                    //print
                    values.add(root.val);
                    //go to right
                    root = root.right;
                }
            }
        }
    }
}