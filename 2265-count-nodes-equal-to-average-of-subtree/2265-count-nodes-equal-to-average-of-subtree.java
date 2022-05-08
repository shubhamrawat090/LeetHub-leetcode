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
    //pair class storing sum, no. of nodes and avegerge value for each node
    class Pair {
        int sum;
        int noOfNodes;
        int average;
        
        Pair(int s, int n, int a) {
            sum = s;
            noOfNodes = n;
            average = a;
        }
    }
    //counting the no. of nodes satisfying the condition
    int count = 0;
    
    //driver function
    public int averageOfSubtree(TreeNode root) {
        helper(root);
        return count;
    }
    
    //helper function
    public Pair helper(TreeNode root) {
        if(root == null){
            return new Pair(0,0,0);
        }
        
        //get ans from left and right subtree
        Pair left = helper(root.left);
        Pair right = helper(root.right);
        
        //curr node initialized
        Pair curr = new Pair(0,0,0);
        //sum = sum of left, right and root node
        curr.sum += left.sum + right.sum + root.val;
        //no. of nodes = left + right + curr node(1)
        curr.noOfNodes += left.noOfNodes + right.noOfNodes + 1;
        //average of curr  = sum/no. of nodes
        curr.average = curr.sum / curr.noOfNodes;
        
        //if average matches curr node's value then count it in our ans
        if(curr.average == root.val) count++;
        
        //return this result for next nodes
        return curr;
    }
}