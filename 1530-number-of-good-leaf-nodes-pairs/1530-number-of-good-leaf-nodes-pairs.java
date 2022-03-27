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
    int ans = 0;
    
    private ArrayList<Integer> helper(TreeNode root, int d){
        if(root == null){
            ArrayList<Integer> ans = new ArrayList<>();
            ans.add(0);
            return ans;
        }
        
        if(root.left == null && root.right == null){
            ArrayList<Integer> ans = new ArrayList<>();
            ans.add(1);
            return ans;
        }
        
        ArrayList<Integer> leftAns = helper(root.left, d);
        ArrayList<Integer> rightAns = helper(root.right, d);
        
        for(int a: leftAns){
            for(int b: rightAns){
                if(a!=0 && b!=0 && a+b<=d){
                    ans++;
                }
            }
        }
        
        ArrayList<Integer> returnVal = new ArrayList<>();
        for(int a: leftAns){
            if(a!=0 && a+1<d){
                returnVal.add(a+1);
            }
        }
        
        for(int b: rightAns){
            if(b!=0 && b+1<d){
                returnVal.add(b+1);
            }
        }
        
        return returnVal;
    }
    
    public int countPairs(TreeNode root, int distance) {
        helper(root, distance);
        return ans;
    }
}