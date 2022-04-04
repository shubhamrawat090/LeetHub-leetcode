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
        for(int i = 1; i <= k - 1; i++)
            nxt = nxt.next;
        ListNode marker1 = nxt;
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