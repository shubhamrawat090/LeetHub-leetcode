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
    TreeNode parx; //parent of x
    TreeNode pary; //parent of y
    int levelx; // level of x
    int levely; // level of y
    
    void levelOrderTraversal(TreeNode root, int x, int y) {
        Queue<TreeNode> que = new ArrayDeque(); //processes nodes level by level
        que.add(root);
        int level = 1;//signifies which level we are at starting from 1
        while(que.size() != 0) { // work till queue is empty
            int size = que.size();
            while(size-->0) {
                TreeNode rnode = que.remove();
                if(rnode.left != null) {//if curr node's left child exists
                    //if curr node's left child matches x then the level of x is 1 below our current level
                    if(rnode.left.val == x) {
                        parx = rnode;
                        levelx = level + 1;
                    }
                    //if curr node's right child matches x then the level of x is 1 below our current level
                    if(rnode.left.val == y) {
                        pary = rnode;
                        levely = level + 1;
                    }
                    que.add(rnode.left);
                }
                //same work as above is done if a right child exists
                if(rnode.right != null) {
                    if(rnode.right.val == x) {
                        parx = rnode;
                        levelx = level + 1;
                    }
                    if(rnode.right.val == y) {
                        pary = rnode;
                        levely = level + 1;
                    }
                    que.add(rnode.right);
                }
            }
            //this level is added in queue go to next level
            level++;
        }
    }
    
    public boolean isCousins(TreeNode root, int x, int y) {
        if(x == root.val || y == root.val) {//if x or y are root then they cannot be cousins as at root level there is only 1 node => no siblings => no cousins
            return false;
        }
        
        //get parent of x & y and their levels as well via BFS levelOrder 
        levelOrderTraversal(root, x, y);
        
        //if x & y have different parents and are on the same level it means they are cousins
        if(parx != pary && levelx == levely) {
            return true;
        }
        
        return false;
    }
}