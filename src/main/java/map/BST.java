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
        put(key, value, root);
    }

    private void put(Key key, Value value, Node node) {
        //if (node == null) {
        //    node=new Node()
        //}
    }

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
        if (root == null) {
            return 0;
        }
        return root.n;
    }
}
