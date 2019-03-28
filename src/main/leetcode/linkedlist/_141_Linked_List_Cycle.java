package linkedlist;

public class _141_Linked_List_Cycle {
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next== null) return false;
        ListNode cur = head;
        while(cur != null) {
            if(cur == cur.next) return true;
            // 交换顺序
            ListNode next = cur.next;
            cur.next = cur;
            cur = next;
        }
        return false;
    }
}
