package map;

/**
 * 二分查找树
 *
 * @author luokai
 * @description:
 * @date: 2020/1/2
 * @version: 1.0
 */
public class BST<Key extends Comparable, Value> implements ST<Key, Value> {

    private Node root;

    private int max = 0;

    private class Node {
        private Key key;
        private Value value;
        private Node right;
        private Node left;
        /**
         * 以当前节点为root的总节点数
         */
        private int n;
        /**
         * 层高
         */
        private int high;

        public Node(Key key, Value value, int n, int high) {
            this.key = key;
            this.value = value;
            this.n = n;
            this.high = high;
        }
    }

    @Override
    public void put(Key key, Value value) {
        root = put(key, value, root, 1);
    }

    private Node put(Key key, Value value, Node node, int high) {
        if (node == null) {
            Node temp = new Node(key, value, 1, high + 1);
            if (temp.high > max) {
                max = temp.high;
            }
            return temp;
        }
        int cmd = key.compareTo(node.key);
        if (cmd > 0) {
            node.left = put(key, value, node.left, high + 1);
        } else if (cmd < 0) {
            node.right = put(key, value, node.right, high + 1);
        } else {
            node.value = value;
        }
        node.n = size(node.right) + size(node.left) + 1;
        return node;
    }

    /**
     * 递归实现版本
     */
    @Override
    public Value get(Key key) {
        return get(key, root);
    }

    private Value get(Key key, Node node) {
        if (node == null) {
            return null;
        }
        if (key.compareTo(node.key) > 0) {
            return get(key, node.left);
        } else if (key.compareTo(node.key) < 0) {
            return get(key, node.right);
        } else {
            return node.value;
        }
    }

    @Override
    public void delete(Key key) {

    }

    @Override
    public boolean contains(Key key) {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public int size() {
        return size(root);
    }

    private int size(Node node) {
        if (node == null) {
            return 0;
        }
        return node.n;
    }

    @Override
    public String toString() {
        //TODO 中序遍历 + 格式化
        return null;
    }

    public static void main(String[] args) {
        BST bst = new BST();
        bst.put(1, "A1");
        bst.put(5, "A5");
        bst.put(9, "A9");
        bst.put(7, "A7");

        System.out.println(bst);
    }

}
