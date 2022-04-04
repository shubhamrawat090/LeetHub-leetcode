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
class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        ListNode prev = head, nxt = head;
        
        //move nxt to kth node(1 based indexing)
        for(int i = 1; i <= k - 1; i++)
            nxt = nxt.next;
        ListNode marker1 = nxt;
        
        //keep a gap of k nodes and move prev(at head) and nxt(at k node) till next reaches last node
        while(nxt.next!=null)
        {
            prev = prev.next;
            nxt = nxt.next;
        }
        
        // swap(prev.val, marker1.val);
        int temp = prev.val;
        prev.val = marker1.val;
        marker1.val = temp;
        
        return head;
    }
}