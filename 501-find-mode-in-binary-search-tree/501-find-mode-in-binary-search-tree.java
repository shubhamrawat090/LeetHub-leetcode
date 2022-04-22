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
    Integer prev = null;//prev variable to compare with current node's value
    int count = 1;//initial count is 1 i.e. 1 element is found
    int maxCount = 0;//maximum occurring element count
    
    public void inorder(TreeNode root, List<Integer> modes) {
        //if no nodes then do nothing
        if(root == null) return;
        
        //left traversal
        inorder(root.left, modes);
        
        //root processing
        
        //check current only if prev is not NULL
        if(prev != null) {
            //if curr node's val is same as prev val then increment it's count
            if(prev == root.val) {
                count++;
            }else {
                //reset the counter to 1 for new value encountered
                count = 1;
            }
        }
        
        //if count of our element is greater than current maximum occurring element count
        if(count > maxCount) {
            //set maxCount to curr element's count
            maxCount = count;
            modes.clear();//clear the list
            modes.add(root.val); //add our value as it is right now the highest occurring
        }else if(count == maxCount) {
            //if curr element's count is same as that of maxCount then add our element to the list of modes as there are more than 1 mode
            modes.add(root.val);
        }
        
        //set prev = curr node's val for next node iteration
        prev = root.val;
        
        //right traversal
        inorder(root.right, modes);
    }
    
    public int[] findMode(TreeNode root) {
        List<Integer> modes = new ArrayList<>();
        
        //inorder traversal is increasing order so finding mode will be easier as all same elements are grouped together
        inorder(root, modes);
        
        //convert the list to integer array and return it
        int[] res = new int[modes.size()];
        for(int i=0; i<modes.size(); i++){
            res[i] = modes.get(i);
        }
        
        return res;
    }
}