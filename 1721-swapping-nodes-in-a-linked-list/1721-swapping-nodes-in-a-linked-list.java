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
        if(head==null || head.next==null) return head;
        ListNode left = new ListNode();
        ListNode right = new ListNode();
        ListNode temp = head;
        int size=0;
        while(temp!=null){
            temp = temp.next;
            size++;
        }
        
        // if(k==size-k+1){
        //     return head;
        // }
        temp=head;
        for(int i=0; i<size; i++){
            if(i==k-1){
                left = temp;
            }
            if(i==size-k){
                right = temp;
            }
            temp=temp.next;
        }
      
        int tempVal =left.val;
        left.val = right.val;
        right.val = tempVal;
        
        return head;
    }
}