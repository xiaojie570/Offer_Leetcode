package linkedlist;

public class _21_Merge_Two_Sorted_Lists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode retHead = new ListNode(0);
        ListNode ret = retHead;
        ListNode listNode1 = l1, listNode2 = l2;
        while(listNode1 != null && listNode2 != null) {
            if(listNode1.val < listNode2.val) {
                ret.next = new ListNode(listNode1.val);
                listNode1 = listNode1.next;
            } else {
                ret.next = new ListNode(listNode2.val);
                listNode2 = listNode2.next;
            }
            ret = ret.next;
        }
        ret.next = listNode1 != null ? listNode1 : listNode2;
        return retHead.next;
    }
}
