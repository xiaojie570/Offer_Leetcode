package linkedlist;

public class _206_Reverse_Linked_List {

    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode temp = head.next;
        ListNode pre = head;
        ListNode post;
        head.next = null;
        while(temp != null) {
            post = temp.next;
            temp.next = pre;
            pre = temp;
            temp = post;
        }
        return pre;
    }
}
