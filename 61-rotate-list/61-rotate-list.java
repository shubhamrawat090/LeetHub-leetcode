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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next==null) return head;
        
        ListNode fast = head, slow = head;
        
        int size = sizeOfLL(head);
        k=k%size;
        
        for(int i=0; i<k; i++){
            fast = fast.next;
        }
        
        while(fast.next!=null){
            slow = slow.next;
            fast = fast.next;
        }
        
        //Head of part2
        ListNode secondHead = slow.next;
        
        //separating 2 parts
        slow.next = null;
        
        //reverse part1
        head = reverseList(head);
        
        slow=head;
        
        //getting tail pointer of first part
        while(slow.next!=null){
            slow=slow.next;
        }
        
        //reverse part2
        secondHead = reverseList(secondHead);
            
        //joining 2 parts
        slow.next = secondHead;
        
        //reversing entire list
        head = reverseList(head);
        
        return head;
    }
    
    int sizeOfLL(ListNode head){
        int c = 0;
        while(head!=null){
            head = head.next;
            c++;
        }
        
        return c;
    }
    
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode tail = head;
        while(tail.next!=null){
            tail = tail.next;
        }
        ListNode prev = null, curr=head;
        while(curr!=null){
            ListNode ahead = curr.next;
            curr.next = prev;
            prev = curr;
            curr = ahead;
        }
        
        ListNode temp = head;
        head = tail;
        tail = temp;
        
        return head;
    }
}