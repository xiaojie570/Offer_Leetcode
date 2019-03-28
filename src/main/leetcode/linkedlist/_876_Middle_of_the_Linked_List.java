package linkedlist;

public class _876_Middle_of_the_Linked_List {
    class ListNode {
        int val;
        ListNode next;
    }
    public ListNode middleNode(ListNode head) {
        ListNode h = head;
        ListNode pre1 = head,pre2 = head;
        while(pre2 != null && pre2.next != null) {
            pre2 = pre2.next.next;
            pre1 = pre1.next;
        }
        return pre1;
    }
}
