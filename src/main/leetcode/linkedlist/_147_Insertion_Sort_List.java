package linkedlist;

public class _147_Insertion_Sort_List {
    public ListNode insertionSortList(ListNode head) {
        if( head == null ){
            return head;
        }

        ListNode helper = new ListNode(0); //做一个头节点
        ListNode cur = head; //这个变量是head
        ListNode pre = helper; //insert node between pre and pre.next
        ListNode next = null; //the next node will be inserted
        //not the end of input list
        while( cur != null ){
            next = cur.next;
            //找到需要插入的位置
            while( pre.next != null && pre.next.val < cur.val ){
                pre = pre.next;
            }
            //插入元素
            cur.next = pre.next;
            pre.next = cur;
            pre = helper;
            cur = next;
        }

        return helper.next;
    }


}
