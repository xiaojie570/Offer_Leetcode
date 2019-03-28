public class _26_ {
    class TreeNode{
        int data;
        TreeNode left;
        TreeNode right;
    }
    public boolean hashSubTree(TreeNode  t1, TreeNode  t2) {
        boolean flag = false;
        // 寻找相同的根节点
        if(t1 != null && t2 != null) {//只有根结点相同了，才能向下去找
            if(t1.data == t2.data)
                flag = doSubTree(t1,t2);
            if(!flag)
                flag = hashSubTree(t1.left,t2);
            if(!flag)
                flag = hashSubTree(t1.right,t2);
        }
        return flag;
    }
    private boolean doSubTree(TreeNode t1, TreeNode t2) {
        if(t2 == null) return true;
        if(t1 == null) return false;
        if(t1.data != t2.data)
            return false;
        return doSubTree(t1.left,t2.left) && doSubTree(t1.right,t2.right);
    }
}
