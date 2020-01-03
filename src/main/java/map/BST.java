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
        root = put(key, value, root);
    }

    private Node put(Key key, Value value, Node node) {
        if (node == null) {
            return new Node(key, value, 1);
        }
        int cmd = key.compareTo(node.key);
        if (cmd < 0) {
            node.left = put(key, value, node.left);
        } else if (cmd > 0) {
            node.right = put(key, value, node.right);
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
        root = delete(root, key);
    }

    private Node delete(Node node, Key key) {
        if (node == null) {
            return null;
        }
        int cmd = key.compareTo(node.key);
        if (cmd < 0) {
            node.left = delete(node.left, key);
        } else if (cmd > 0) {
            node.right = delete(node.right, key);
        } else {
            //删除逻辑
            if (node.left == null) {
                return node.right;
            }
            if(node.right == null){
                return node.left;
            }
            //找出最小的节点
            Node min = min(node.right);
            min.left = node.left;
            min.right = deleteMin(min.right);
            node = min;
        }
        node.n = size(node.left) + size(node.right) + 1;
        return node;
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
        BST bst = new BST();
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
