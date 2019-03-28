package linkedlist;

public class _234_Palindrome_Linked_List {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;
        // [1]将链表分为两个部分
        ListNode pre = null, slow = head, fast = head, l1 = head;
        while(fast != null && fast.next != null){
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null;
        //[2] 将第二部分反转
        ListNode l2 = fast == null ?reverse(slow):reverse(fast);
        //[3] 反转之后比较两个部分
        while(l1 != null && l2 != null) {
            if(l1.val != l2.val) return false;
            l1 = l1.next;
            l2 = l2.next;
        }
        return true;
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null,curr = head, next = null;
        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        _234_Palindrome_Linked_List test = new _234_Palindrome_Linked_List();
        System.out.println(test.isPalindrome(new ListNode(1)));;
    }
}
