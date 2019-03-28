import java.util.ArrayList;
import java.util.Arrays;

public class _54_ {
    class Node{
        int val; Node left; Node right;
    }
    private ArrayList<Integer> arrayList = new ArrayList<>();
    public void inTraversal(Node node) {
        if(node == null) return;
        if(node.left != null)
            inTraversal(node.left);
        arrayList.add(node.val);
        if(node.right != null)
            inTraversal(node.right);
    }
    public void getK(Node node,int k) {
        if(node == null || k <0 ) return ;
        inTraversal(node);
        if(k > arrayList.size()) return;
        System.out.println(arrayList.get(k - 1));
   }
}
