package map;

import java.util.Arrays;

/**
 * @author luokai
 * @description:
 * @date: 2020/1/1
 * @version: 1.0
 */
public class BinarySearchST<Key extends Comparable, Value> implements ST<Key, Value> {
    private Key[] keys;
    private Value[] values;

    private int size;

    public BinarySearchST(int capacity) {
        keys = (Key[]) new Comparable[capacity];
        values = (Value[]) new Comparable[capacity];
        size = 0;
    }

    @Override
    public void put(Key key, Value value) {
        int i = rank(key);
        if (i < size && keys[i].compareTo(key) == 0) {
            values[i] = value;
            return;
        }
        //集体向右移动一个
        for (int j = size; j > i; j--) {
            values[j] = values[j - 1];
            keys[j] = keys[j - 1];
        }
        values[i] = value;
        keys[i] = key;
        size++;
    }

    @Override
    public Value get(Key key) {
        if (isEmpty()) {
            return null;
        }
        int i = rank(key);
        if (i < size && keys[i].compareTo(key) == 0) {
            return values[i];
        }
        return null;
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
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Value min() {
        return null;
    }

    @Override
    public String toString() {
        return "{" + "keys=" + Arrays.toString(keys) +
                ",\r\nvalues=" + Arrays.toString(values) +
                '}';
    }

    /**
     * 递归版本
     */

    private int rank(Key key) {
        return rank(key, 0, size - 1);
    }


    private int rank(Key key, int s, int e) {
        if (s > e) {
            return s;
        }
        int mid = s + (e - s) / 2;
        if (keys[mid].compareTo(key) > 0) {
            return rank(key, s, mid - 1);
        } else if (keys[mid].compareTo(key) < 0) {
            return rank(key, mid + 1, e);
        } else {
            return mid;
        }
    }

    public static void main(String[] args) {
        BinarySearchST st = new BinarySearchST(10);
        st.put(1, "a");
        st.put(3, "b");
        st.put(3, "b1");
        st.put(2, "c");

        System.out.println(st);
    }
}
