package linkedlist;

public class _83_Remove_Duplicates_from_Sorted_List {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode temp = head;
        while(temp.next != null) {
            if(temp.val != temp.next.val)
                temp = temp.next;
            else
                temp.next = temp.next.next;
        }
        return head;
    }
}
