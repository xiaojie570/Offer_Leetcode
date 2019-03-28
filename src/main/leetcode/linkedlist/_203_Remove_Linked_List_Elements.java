package linkedlist;

public class _203_Remove_Linked_List_Elements {
    public ListNode removeElements(ListNode head, int val) {
        ListNode ret = new ListNode(0);
        ret.next = head;
        ListNode pre =ret;
        while(pre.next != null) {
            if(pre.next.val == val)
                pre.next = pre.next.next;
            else{
                pre = pre.next;
            } if(pre == null) break;
        }
        return ret.next;
    }
}
