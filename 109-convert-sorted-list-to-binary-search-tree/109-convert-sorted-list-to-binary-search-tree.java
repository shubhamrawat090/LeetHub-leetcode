/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    public TreeNode sortedListToBST(ListNode head) {
        return constructBST(head);
    }
    
    public TreeNode constructBST(ListNode head){
        //return null if no nodes exist
        if(head == null)
            return null;
        
        //find middle of list
        ListNode mid = mid(head);
        //store middle of list's value in BST nodes
        TreeNode node = new TreeNode(mid.val);
        
        //mid == head, only 1 node exists
        if(mid == head)
            return node;
        
        //on the left of that node, join BST of left half of linked list
        node.left = constructBST(head);
        //on the right of that node, join BST of right half of linked list
        node.right = constructBST(mid.next);

        //return the BST
        return node;
    }
    
    public ListNode mid(ListNode head){
        
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = head;
        
        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        
        if(prev != null)
            prev.next = null;
        return slow;
    }
}