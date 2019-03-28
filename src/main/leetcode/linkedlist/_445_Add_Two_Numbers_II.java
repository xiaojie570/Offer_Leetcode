package linkedlist;

import java.math.BigInteger;

public class _445_Add_Two_Numbers_II {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        StringBuilder sb1 = new StringBuilder();
        sb1.append(l1.val);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(l2.val);
        while(l1.next != null){
            l1 = l1.next;
            sb1.append(l1.val);
        }
        while(l2.next != null) {
            l2 = l2.next;
            sb2.append(l2.val);
        }
        BigInteger bi = new BigInteger(sb1.toString());
        BigInteger n = new BigInteger(sb2.toString()).add(bi);
        String s = n.toString();
        ListNode head = new ListNode(s.charAt(0)-48);
        ListNode tmp = head;
        for(int i=1; i<s.length(); i++){
            ListNode ln = new ListNode(s.charAt(i)-48);
            tmp.next = ln;
            tmp = ln;
        }
        return head;
    }
}
