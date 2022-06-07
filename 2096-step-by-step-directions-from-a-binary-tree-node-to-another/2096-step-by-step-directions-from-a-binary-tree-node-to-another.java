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
    public String getDirections(TreeNode root, int startValue, int destValue) {
        ArrayList<TreeNode> list1 = n2R(root, startValue);
        ArrayList<TreeNode> list2 = n2R(root, destValue);
        
        int i=list1.size()-1;
        int j=list2.size()-1;
        
        while(i>=0 && j>=0) {
            if(list1.get(i) == list2.get(j)) {
                i--;
                j--;
            } else {
                break;
            }
        }
        
        i++;
        j++;
        
        StringBuilder ans = new StringBuilder();
        
        for(int ii=0; ii<i; ii++) {
            ans.append("U");
        }
        
        for(int jj=j; jj>0; jj--) {
            if(list2.get(jj-1) == list2.get(jj).left) {
                ans.append("L");
            } else {
                ans.append("R");
            }
        }
        
        return ans.toString();
    }
    
    private ArrayList<TreeNode> n2R(TreeNode root, int val){
        if(root == null) {
            return new ArrayList<>();
        }
        
        if(root.val == val) {
            ArrayList<TreeNode> ret = new ArrayList<>();
            ret.add(root);
            return ret;
        } else {
            ArrayList<TreeNode> left = n2R(root.left, val);
            if(left.size()>0) {
                left.add(root);
                return left;
            } else {
                ArrayList<TreeNode> right = n2R(root.right, val);
                if(right.size()>0) {
                    right.add(root);
                    return right;
                }
            }
        }
        
        return new ArrayList<>(); 
    }
}