package tree;

public class _538_Convert_BST_to_Greater_Tree {
    public TreeNode convertBST(TreeNode root) {
        recur(root, 0);
        return root;
    }

    public int recur(TreeNode current, int parent) {
        if(current == null)
            return 0;
        current.val += recur(current.right, parent) + parent;
        return current.val - parent + recur(current.left, current.val);
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(5);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(13);
        node.left = left;
        node.right = right;
        _538_Convert_BST_to_Greater_Tree test = new _538_Convert_BST_to_Greater_Tree();
        test.convertBST(node);
    }
}
