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
    public ListNode reverseList(ListNode head) {
        //if there is 1 or 0 nodes, we can't reverse it
        if(head == null || head.next == null) {
            return head;
        }
        ListNode tail = head;
        //getting tail ptr at last of linked list
        while(tail.next!=null) {
            tail = tail.next;
        }
        //take curr ptr and prev ptr for each node
        //point curr to prev, reversing the links of the node from next ptr to prev ptr
        ListNode curr = head, prev = null;
        while(curr!=null) {
            //storing the ahead LL so that we don't lose the LL ahead while reversing the link of curr ptr
            ListNode ahead = curr.next;
            curr.next = prev;
            prev = curr;
            curr = ahead;
        }
        
        //finally reversing the head and tail ptr
        ListNode temp = head;
        head = tail;
        tail = temp;
        
        return head;
    }
}