package map;

/**
 * 二分查找树
 *
 * @author luokai
 * @description:
 * @date: 2020/1/2
 * @version: 1.0
 */
public class BST<K extends Comparable, V> implements ST<K, V> {
    private Node root;

    private class Node {
        private K key;
        private V value;
        private Node right;
        private Node left;
        /**
         * 以当前节点为root的总节点数
         */
        private int n;

        public Node(K key, V value, int n) {
            this.key = key;
            this.value = value;
            this.n = n;
        }
    }

    @Override
    public void put(K key, V value) {

    }

    @Override
    public V get(K key) {
        return null;
    }

    @Override
    public void delete(K key) {

    }

    @Override
    public boolean contains(K key) {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return root.n;
    }
}
