import java.util.LinkedList;
import java.util.Queue;

public class _32_ {
    class Node{
        int val; Node left; Node right;
    }
    public void preTraversal(Node node) {  //前序
        System.out.println(node.val);
        if(node.left != null)
            preTraversal(node.left);
        if(node.right != null)
            preTraversal(node.right);
    }
    public void inTraversal(Node node) { // 中序
        if(node.left != null)
            inTraversal(node.left);
        System.out.println(node.val);
        if(node.right != null)
            inTraversal(node.right);
    }
    public void postTraversal(Node node) { // 后序
        if(node.left != null)
            postTraversal(node.left);
        if(node.right != null)
            postTraversal(node.right);
        System.out.println(node.val);
    }

    public void level(Node root) {
        int  i = 0;
        Node last = root;  // 当前行最右节点
        Node nlast = null; // 下一行最右节点
        Node temp;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            temp = queue.poll();
            System.out.println(temp);
            if(temp.left != null) {
                queue.offer(temp.left);
                nlast = temp.left;
            }
            if(temp.right != null) {
                queue.offer(temp.right);
                nlast = temp.right;
            }
            if(temp == last) {
                System.out.println(i++);
                last = nlast;
            }
        }
    }
}
