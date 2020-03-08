package leetcode.other;


/**
 * 请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和 pop_front 的时间复杂度都是O(1)。
 * <p>
 * 若队列为空，pop_front 和 max_value 需要返回 -1
 */
public class Solution59 {

    /**
     * Your MaxQueue object will be instantiated and called as such:
     * MaxQueue obj = new MaxQueue();
     * int param_1 = obj.max_value();
     * obj.push_back(value);
     * int param_3 = obj.pop_front();
     * 1 2 1
     */

    //static class MaxQueue {
    //    private class Node {
    //        int value;
    //        Node next;
    //        Node pre;
    //        Node maxNext;
    //
    //        public Node(int value) {
    //            this.value = value;
    //        }
    //    }
    //
    //    private Node tail = new Node(-1);
    //    private Node head = new Node(-1);
    //
    //    private Node maxHead = new Node(-1);
    //    private Node maxTail = new Node(-1);
    //
    //    public MaxQueue() {
    //        head.next = tail;
    //        tail.pre = head;
    //
    //        maxHead.next = maxTail;
    //        maxTail.pre = maxHead;
    //    }
    //
    //    public int max_value() {
    //        if (maxHead.next == maxTail) {
    //            return -1;
    //        }
    //        return maxHead.next.value;
    //    }
    //
    //    public void push_back(int value) {
    //        Node node = new Node(value);
    //        Node preNode = tail.pre;
    //        preNode.next = node;
    //        node.pre = preNode;
    //
    //        tail.pre = node;
    //        node.next = tail;
    //
    //        Node temp = maxHead;
    //        while (temp.next != maxTail && value < temp.next.value) {
    //            temp = temp.next;
    //        }
    //        Node maxNode = new Node(value);
    //        Node next = temp.next;
    //
    //        temp.next = maxNode;
    //        maxNode.pre = temp;
    //
    //        maxNode.next = next;
    //        next.pre = maxNode;
    //
    //    }
    //
    //    public int pop_front() {
    //        Node nextNode = head.next;
    //        if (nextNode == null) {
    //            return -1;
    //        }
    //        Node next2Node = nextNode.next;
    //        if (next2Node == null) {
    //            return -1;
    //        }
    //        head.next = next2Node;
    //        next2Node.pre = head;
    //
    //        int value = nextNode.value;
    //        if (value == maxHead.next.value) {
    //            maxHead.next = maxHead.next.next;
    //            maxHead.next.pre = maxHead;
    //        } else {
    //            maxTail.pre = maxTail.pre.pre;
    //            maxTail.pre.next = maxTail;
    //        }
    //        nextNode = null;
    //        return value;
    //    }
    //}


    static class MaxQueue {
        int[] a;
        int[] max;

        int head = 0;
        int tail = 0;
        int maxHead = 0;
        int maxTail = 0;

        public MaxQueue() {
            a = new int[10000];
            max = new int[10000];
        }

        public int max_value() {
            if (maxHead == maxTail) {
                return -1;
            }
            return max[maxTail];
        }

        public void push_back(int value) {
            a[tail++] = value;
            //max[maxIndex] = value;
            while (maxTail != maxHead && max[maxTail-1] < value) {
                maxTail--;
            }
            max[maxTail ++] = value;
        }

        public int pop_front() {
            if (head == tail) {
                return -1;
            }
            int val = a[head++];
            if (val == max[maxHead]) {
                maxHead++;
            }
            return val;
        }
    }

    public static void main(String[] args) {
        MaxQueue solution = new MaxQueue();
        solution.push_back(1);
        solution.push_back(2);
        System.out.println(solution.max_value());

        solution.pop_front();
        System.out.println(solution.max_value());


    }


}