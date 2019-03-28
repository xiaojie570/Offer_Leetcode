import java.util.ArrayList;

public class _34_ {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
    }
    private ArrayList<ArrayList<Integer>> rets = new ArrayList<>();
    private ArrayList<Integer> path = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> findPaths(TreeNode node,int sum) {
        if(node == null) return null;
        path.add(node.val);
        sum -= node.val;
        if(node.left == null && node.right == null && sum == 0) // 说明找到了
            rets.add(path);
        else if(node.left != null)
            findPaths(node.left,sum);
        else if(node.right != null)
            findPaths(node.right,sum);
        path.remove(path.size() - 1);
        return rets;
    }
}
