/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ArrayList<TreeNode> pToRoot = nodeToRootPath(root, p);
        ArrayList<TreeNode> qToRoot = nodeToRootPath(root, q);
        
        int i = pToRoot.size()-1;
        int j = qToRoot.size()-1;
        TreeNode LCA = null;
        while(i >= 0 && j>= 0){
        
            if(pToRoot.get(i) != qToRoot.get(j)){
                break;
            }

            LCA = pToRoot.get(i);
            i--; j--;
        }
        
        return LCA;
    }
    
    public ArrayList<TreeNode> nodeToRootPath(TreeNode node, TreeNode target){
    // write your code here
    if(node == null){
      return new ArrayList<>();
    }

    if(node.val == target.val){
      ArrayList<TreeNode> temp = new ArrayList<>();
      temp.add(node);
      return temp;
    }

    ArrayList<TreeNode> left = nodeToRootPath(node.left, target);
    //if there is an ans for left subtree then add root to it and return
    if(left.size()>0){
      left.add(node);
      return left;
    }

    ArrayList<TreeNode> right = nodeToRootPath(node.right, target);
    //if there is an ans for right subtree then add root to it and return
    if(right.size()>0){
      right.add(node);
      return right;
    }

    //if no ans is found in either left or right or root then return empty arraylist
    return new ArrayList<>();
  }
}