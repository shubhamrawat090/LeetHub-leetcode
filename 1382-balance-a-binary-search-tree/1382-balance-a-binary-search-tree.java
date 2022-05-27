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
        ArrayList<Integer> list = new ArrayList();
        inOrder(root,list);
        return makeTree(list,0,list.size() - 1);
    }
    public TreeNode makeTree(ArrayList<Integer> list, int low, int high){
        if(low > high){
            return null;
        }   
        int middle = low + (high - low)/2;
        TreeNode node = new TreeNode(list.get(middle));
        node.left= makeTree(list,low,middle - 1);
        node.right= makeTree(list,middle + 1,high);
        return node;
    }
    
    public void inOrder(TreeNode root,ArrayList<Integer> list){
        if(root == null){
            return;
        }
        inOrder(root.left,list);
        list.add(root.val);
        inOrder(root.right,list);
    }
}