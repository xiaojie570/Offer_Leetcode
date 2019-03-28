public class ReverseList {
    static class l {
        int val;
        l next;
    }
    public l reverse(l list) {
        l temp, pre = null, post,head = list;
        temp = list;
        if(list == null) return list;
        if(temp.next == null) return temp;
        while(temp != null) {
            post = temp.next;
            temp.next = pre;
            pre = temp;
            temp = post;
        }
        return head;
    }

    public static void main(String[] args) {
        ReverseList reverseList = new ReverseList();
        l node = new l();

        l node2 = new l();
        l node3 = new l();

        node.val = 1;
        node.next = node2;
        node2.val = 2;
        node2.next = node3;
        node3.val = 3;
        node = reverseList.reverse(node);
        System.out.println(node3.next.val);
    }
}
