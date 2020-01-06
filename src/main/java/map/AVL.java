package map;

/**
 * 平衡二叉树
 *
 * @author luokai
 * @description:
 * @date: 2020/1/2
 * @version: 1.0
 */
public class AVL<Key extends Comparable, Value> implements ST<Key, Value> {

    private Node root;

    private class Node {
        private Key key;
        private Value value;
        private Node right;
        private Node left;
        /**
         * 以当前节点为root的总节点数
         */
        private int n;

        public Node(Key key, Value value, int n) {
            this.key = key;
            this.value = value;
            this.n = n;
        }
    }

    @Override
    public void put(Key key, Value value) {
    }

    private Node put(Key key, Value value, Node node) {
        return null; //TODO
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
        if (key.compareTo(node.key) < 0) {
            return get(key, node.left);
        } else if (key.compareTo(node.key) > 0) {
            return get(key, node.right);
        } else {
            return node.value;
        }
    }

    @Override
    public void delete(Key key) {
    }

    private Node delete(Node node, Key key) {
        return null;//TODO
    }

    /**
     * 删除最小节点
     */
    public void deleteMin() {
        root = deleteMin(root);
    }

    private Node deleteMin(Node node) {
        if (node.left == null) {
            return node.right;
        }
        node.left = deleteMin(node.left);
        node.n = size(node.left) + size(node.right) + 1;
        return node;
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

    @Override
    public Value min() {
        Node min = min(root);
        if (min == null) {
            return null;
        }
        return min.value;
    }

    private Node min(Node node) {
        if (node.left == null) {
            return node;
        }
        return min(node.left);
    }

    private int size(Node node) {
        if (node == null) {
            return 0;
        }
        return node.n;
    }


    public static void main(String[] args) {
        AVL bst = new AVL();
        bst.put(41, 41);
        bst.put(18, 18);
        bst.put(55, 55);
        bst.put(14, 14);
        bst.put(13, 13);
        bst.put(32, 32);
        bst.put(35, 35);

        System.out.println(bst.min());
        bst.delete(18);
        System.out.println(bst.min());


    }

}
