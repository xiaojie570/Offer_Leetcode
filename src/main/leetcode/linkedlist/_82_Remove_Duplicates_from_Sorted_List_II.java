package linkedlist;

public class _82_Remove_Duplicates_from_Sorted_List_II {
    public ListNode deleteDuplicates(ListNode head) {
        //使用快慢指针,
        // 慢指针- 指向重复节点的前一个节点
        // 快指针-指向重复节点的最后一个节点
        ListNode dummy = new ListNode(0), fast = head, slow = dummy;
        slow.next = fast;
        while(fast != null) {
            while (fast.next != null && fast.val == fast.next.val) {
                fast = fast.next;    //找到重复节点的最后一个节点
            }
            if (slow.next != fast) { //duplicates detected.
                slow.next = fast.next; //移除重复节点
                fast = slow.next;     //更新快节点的位置.
            } else { //如果没有重复节点就将快慢指针同时移动
                slow = slow.next;
                fast = fast.next;
            }
        }
        return dummy.next;
    }
}
