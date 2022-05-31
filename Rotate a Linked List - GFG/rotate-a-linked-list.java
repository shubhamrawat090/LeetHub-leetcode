// { Driver Code Starts
import java.util.*;
class Node {
    int data;
    Node next;
    Node(int d) {
        data = d;
        next = null;
    }
} 

class Main {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while (t-- > 0) {
            int n = sc.nextInt();
            
            int a = sc.nextInt();
            Node head = new Node(a);
            Node tail = head;
            
            for (int i=0; i<n-1; i++)
            {
                a = sc.nextInt();
                tail.next = new Node(a);
                tail = tail.next;
            }
            
            int k = sc.nextInt();
            
            Solution ob = new Solution();
            head = ob.rotate(head,k);
            printList(head);
        }
    }
    
    public static void printList(Node n) {
        while (n != null) {
            System.out.print(n.data + " ");
            n = n.next;
        }
        System.out.println();
    }
}
// } Driver Code Ends


/* node of linked list:

class Node{
    int data;
    Node next;
    Node(int d){
        data=d;
        next=null;
    }
}

*/

class Solution{
    //Function to rotate a linked list.
    public Node rotate(Node head, int k) {
        // add code here
        int size = sizeOfLL(head);
        return rotateRight(head, size-k, size);
    }
    
    public Node rotateRight(Node head, int k, int size) {
        if(head==null || head.next==null) return head;
        
        Node fast = head, slow = head;
        
        k=k%size;
        
        for(int i=0; i<k; i++){
            fast = fast.next;
        }
        
        while(fast.next!=null){
            slow = slow.next;
            fast = fast.next;
        }
        
        //Head of part2
        Node secondHead = slow.next;
        
        //separating 2 parts
        slow.next = null;
        
        //reverse part1
        head = reverseList(head);
        
        slow=head;
        
        //. getting tail pointer of first part
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
    
    int sizeOfLL(Node head){
        int c = 0;
        while(head!=null){
            head = head.next;
            c++;
        }
        
        return c;
    }
    
    public Node reverseList(Node head) {
        if(head == null || head.next == null) return head;
        Node tail = head;
        while(tail.next!=null){
            tail = tail.next;
        }
        Node prev = null, curr=head;
        while(curr!=null){
            Node ahead = curr.next;
            curr.next = prev;
            prev = curr;
            curr = ahead;
        }
        
        Node temp = head;
        head = tail;
        tail = temp;
        
        return head;
    }
}
