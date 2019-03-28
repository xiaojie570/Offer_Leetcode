package linkedlist;

public class _142_Linked_List_CycleⅡ {
    public ListNode detectCycle(ListNode head) {
       if(head == null || head.next == null || head.next.next == null)
           return null;
       ListNode slow = head.next;
       ListNode fast = head.next.next;
       while(slow != fast) {
           if (fast.next == null || fast.next.next == null)
               return null;
           slow = slow.next;
           fast = fast.next.next;
       }
       fast = head;
       while(fast != slow) {
           fast = fast.next;
           slow = slow.next;
       }
       return fast;
    }
}
