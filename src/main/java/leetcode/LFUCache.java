package leetcode;

/**
 * 数据结构
 * LFU
 * TODO 有待优化
 */
public class LFUCache {
    class Node {
        int key;
        int value;
        int time;
    }

    private int capacity;
    private Node[] list;

    private int size;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        list = new Node[capacity];
        size = 0;
    }

    public int get(int key) {
        int index = getIndex(key);
        if (index == -1) {
            return -1;
        }
        return list[index].value;
    }

    private int getIndex(int key) {
        int i;
        for (i = 0; i < size; i++) {
            if (list[i].key == key) {
                break;
            }
        }
        if (i >= size) {
            return -1;
        }
        list[i].time++;
        Node temp = list[i];
        int index = i - 1;
        //看是否移动,之和前面的比较
        return trans(index, temp);
    }

    public void put(int key, int value) {
        int index = getIndex(key);
        if (index != -1) {
            list[index].value = value;
            return;
        }
        Node newNode = new Node();
        newNode.key = key;
        newNode.value = value;
        newNode.time = 1;

        if (size == capacity) {
            size--;
        }
        if (size == 0) {
            list[0] = newNode;
        } else if (size < 0) {
            return;
        } else {
            trans(size - 1, newNode);
        }
        size++;
    }

    private int trans(int end, Node node) {
        int index = end;
        while (index >= 0 && node.time >= list[index].time) {
            list[index + 1] = list[index];
            index--;
        }
        list[index + 1] = node;
        return index + 1;
    }

    public static void main(String[] args) {
        LFUCache cache = new LFUCache(0 /* capacity (缓存容量) */);

        cache.put(0, 0);
        cache.get(0);

    }
}