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
    //on each dfs iteration it stores all paths encountered
    private List<String> res = new ArrayList<>();
    
    public List<String> binaryTreePaths(TreeNode root) {
        dfs(root, new StringBuilder());// pass to helper function with a stringbuilder for getting paths as we traverse
        return res;// return all the paths stored in golbal variable
    }
    
    //helper function
    private void dfs(TreeNode root, StringBuilder sb) {
        //if tree doesn't exist do nothing
        if (root == null) {
            return;
        }
        
        //if adding first time then just add the value of current node
        if (sb.length() == 0) {
            sb.append(root.val);
        }
        //if there is already a path in sb then add "->our value" to it
        else {
            sb.append("->");
            sb.append(root.val);
        }
        
        //on encountering leaf node STORE THE PATH INSIDE GLOBAL VARIABLE
        if (root.left == null && root.right == null) {
            res.add(sb.toString());
        }
        
        //length of sb till our current path is stored
        int len = sb.length();
        //go to left subtree and add all paths to it
        dfs(root.left, sb);
        //reset path back to our root's val
        sb.setLength(len);
        //now go to right subtree and all paths to it
        dfs(root.right, sb);
    }
}