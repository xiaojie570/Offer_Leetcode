
public class AVLTree<E> {
    private static final int LH = 1; // 左高
    private static final int EH = 0; // 一样高
    private static final int RH = -1; // 右边高

    // 树节点
    static class Node {
        int data;
        Node parent;
        Node left;
        Node right;
        int balance = EH;

        public Node() {
        }

        public Node(int data, Node parent) {
            this.data = data;
            this.parent = parent;
        }
    }

    private Node root = null; // 树的根节点
    private int size = 0;

    public AVLTree() {
    }

    // 左旋一次
    private void leftRotate(Node p) {
        if (p != null) {
            Node temp = p.right;
            p.right = temp.right;
            if (root.right != null)
                root.right.parent = p;
            temp.parent = p.parent;
            if (p.parent == null)
                root = temp;
            else if (p.parent.left == p)
                p.parent.left = temp;
            else
                p.parent.right = temp;
            temp.right = p;
            p.parent = temp;
        }
    }

    // 右旋一次
    private void rightRotate(Node p) {
        if (p != null) {
            Node temp = p.left;
            p.left = temp.right;
            if (temp.right != null)
                temp.right.parent = p;
            temp.parent = p.parent;
            if (p.parent == null)
                root = temp;
            else if (p.parent.left == p)
                p.parent.left = temp;
            else
                p.parent.right = temp;
            temp.right = p;
            p.parent = temp;
        }
    }

    /**
     * 平衡二叉树的插入原理：
     * 1. 首先要将找到带插入的位置，将节点插进去，
     * 2. 查完之后要判断它违反了哪种平衡，根据不同的平衡进行不同的处理。
     * 这里主要是使用回溯的方式实现:
     * (1) 其一是修改祖先节点的平衡银子，当插入一个节点的时候只有根节点到插入节点
     * 的路径中的节点的平衡因子会改变，改变的规则是当插入节点再某个节点（称为A）的左子树
     * 中时，A的平衡因子（称为BF）为BF+1。当插入节点在A的右子树中时，A的BF-1。
     * 而判断插入节点在左子树中还是右子树中只要简单的比较它和A的大小
     * (2) 在改变祖先节点的平衡因子的同事，找到最近的一个平衡因子大于2或者小于-2的节点。
     * 从这个节点开始调整最小不平衡树进行旋转调整。因为调整之后，最小不平衡子树的高度和
     * 插入节点之前的高度相同，所以不需要再继续调整祖先节点。
     * 【注意】当调整BF的时候，如果发现某一个节点的BF为0，那就停止向上继续调整。
     */
    public boolean add(int element) {
        Node temp = root; // 用temp节点指向当前树的根节点
        if (temp == null) { // 我们自己去封装这个节点
            root = new Node(element, null);
            size = 1;
            return true;
        }
        int valueCompare;
        Node parent; // 保存temp的父节点
        Comparable e = element;
        do { // 从根开始向下搜索，找到要插入的位置
            parent = temp; // 保存根节点
            valueCompare = e.compareTo(temp.data);
            if (valueCompare < 0)
                temp = temp.left;
            else if (valueCompare > 0)
                temp = temp.right;
            else
                return false;
        } while (temp != null);
        Node node = new Node(element, parent);
        if (valueCompare < 0)
            parent.left = node;
        else
            parent.right = node;
        // 自下向上回溯，查找最近不平衡节点
        while (parent != null) {
            valueCompare = e.compareTo(parent.data);
            if (valueCompare < 0)
                parent.balance++;
            else
                parent.balance--;
            if (parent.balance == 0) break;
            if (Math.abs(parent.balance) == 2)
                rotate(parent); //要去旋转了
            parent = parent.parent;
        }
        size++;
        return true;
    }

    /**
     * 调整的方法：
     * 1. 当最小不平衡子树为2，就是说左子树比右子树高，
     * 如果R的左子树的根节点的BF为1，就右旋
     * 如果R的左子树的根节点BF为 -1，先左后右
     * <p>
     * 2. R为-2时，即右子树高于左子树：
     * 如果R的右子树的根节点的BF为1，则先右后左
     * 如果R的右子树的根节点的BF为-1，则左旋
     *
     * @param parent
     */
    private void rotate(Node parent) {
        if (parent.balance == 2) {
            leftBalance(parent);
        }
        if (parent.balance == -2)
            rightRotate(parent);
    }

    private boolean leftBalance(Node parent) {
        Node left = parent.left;
        switch (left.balance) {
            case LH: // LH=1 左高，右旋调整,旋转后树的高度减小
                left.balance = EH;
                parent.balance = left.balance;
                rightRotate(parent);
                break;
            case RH: // RH = -1 右高，要分情况讨论这个时候
                Node innerR = left.left;
                switch (innerR.balance) {
                    case LH:
                        parent.balance = RH;
                        left.balance = EH;
                        break;
                    case EH:
                        parent.balance = left.balance = EH;
                        break;
                }
                innerR.balance = EH;
                leftRotate(parent.left);
                rightRotate(parent);
                break;
            case EH: //特殊情况4,这种情况在添加时不可能出现，只在移除时可能出现，旋转之后整体树高不变
                left.balance = RH;
                parent.balance = LH;
                rightRotate(parent);
                break;
        }
        return true;
    }


    private boolean rightBalance(Node t) {
        boolean heightLower = true;
        Node r = t.right;
        switch (r.balance) {
            case LH:            //左高，分情况调整
                Node ld = r.left;
                switch (ld.balance) {    //调整各个节点的BF
                    case LH:    //情况1
                        t.balance = EH;
                        r.balance = RH;
                        break;
                    case EH:    //情况2
                        t.balance = r.balance = EH;
                        break;
                    case RH:    //情况3
                        t.balance = LH;
                        r.balance = EH;
                        break;
                }
                ld.balance = EH;
                rightRotate(t.right);
                leftRotate(t);
                break;
            case RH:            //右高，左旋调整
                t.balance = r.balance = EH;
                leftRotate(t);
                break;
            case EH:       //特殊情况4
                r.balance = LH;
                t.balance = RH;
                leftRotate(t);
                heightLower = false;
                break;
        }
        return heightLower;
    }
}
