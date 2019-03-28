package linkedlist;

public class _237_Delete_Node_in_a_Linked_List {
    public void deleteNode(ListNode node) {
        ListNode prev = null;
        while(node.next != null) {
            node.val = node.next.val;
            prev = node;
            node = node.next;
        }
        prev.next = null;
    }
}
