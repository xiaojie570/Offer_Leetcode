package tree;

import java.util.ArrayList;
import java.util.List;

public class _429_Nary_Tree_Level_Order_Traversal {
    public static void main(String[] args) {
        _429_Nary_Tree_Level_Order_Traversal test = new _429_Nary_Tree_Level_Order_Traversal();
    }
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        levelOrderUtil(root, result, 0);
        return result;
    }

    private void levelOrderUtil(Node root, List<List<Integer>> result, int level) {
        if (root == null)
            return;

        if (result.size() == level) {
            result.add(new ArrayList<Integer>());
        }
        List<Integer> t = result.get(level);
        t.add(root.val);
        for (Node next: root.children) {
            levelOrderUtil(next, result, level + 1);
        }
    }
}
