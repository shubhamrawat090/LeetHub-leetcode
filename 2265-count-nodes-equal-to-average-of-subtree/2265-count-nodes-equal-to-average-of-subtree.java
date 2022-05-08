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
    public int averageOfSubtree(TreeNode root) {
        return averageSubtree(root)[0];
    }
    
    // subelemntsAverageEqual, average, sum, elements
    private int [] averageSubtree(TreeNode node){
        int [] result = new int [4];
        
        if (node == null) return result;
        
        int [] left = averageSubtree(node.left);
        int [] right = averageSubtree(node.right);
        
        int sum = left[2] + right[2] + node.val;
        int elements = left[3] + right[3] + 1;
        int avg = sum / elements;
        
        result[2] = sum;
        result[3] = elements;
        result[1] = avg;
        result[0] = left[0] + right[0];
        
        if (avg == node.val)
            ++result[0];
        
        return result;
    }
}