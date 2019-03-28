package linkedlist;

import java.util.HashSet;
import java.util.Set;

public class _817_Linked_List_Components {
    public int numComponents(ListNode head, int[] G) {
        if(head == null || G.length == 0) return 0;
        Set<Integer> g = new HashSet();
        for(int i : G) g.add(i);
        int ret = 0;
        int temp = 0;
        ListNode curr = head;
        while(curr != null) {
            while(head != null && g.contains(head.val)) {
                head = head.next;
                temp ++;
            } if(temp > 0) {
                ret ++;
                temp = 0;
            }
            if(head != null) head = head.next;
        }
        return ret;
    }
}
