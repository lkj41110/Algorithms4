package leetcode.tree;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author luokai
 * @description:
 * @date: 2019/2/28
 * @version: 1.0
 * <p>
 * <p>
 * 中序遍历 （非递归算法）
 * <p>
 * 输入: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 * <p>
 * <p>
 * <p>
 * 输出: [1,3,2]
 */
public class Solution94 {
    class Pair<T, I> {
        private T key;
        private I value;

        public Pair(T key, I value) {
            this.key = key;
            this.value = value;
        }

        public T getKey() {
            return key;
        }

        public void setKey(T key) {
            this.key = key;
        }

        public I getValue() {
            return value;
        }

        public void setValue(I value) {
            this.value = value;
        }
    }

    /**
     * 迭代算法1
     * 首先想到的，有点想复杂了
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> r = new ArrayList<>();
        if (root == null) {
            return r;
        }
        Stack<Pair<TreeNode, Integer>> stack = new Stack<>();

        stack.add(new Pair<>(root, 1));
        while (stack.size() > 0) {
            Pair<TreeNode, Integer> parent = stack.peek();
            TreeNode pNode = parent.getKey();
            Integer value = parent.getValue();

            TreeNode cNode = null;
            //左子树没有遍历过
            if (value == 1) {
                cNode = pNode.left;
            } else if (value == 0) {
                r.add(pNode.val);
                cNode = pNode.right;
            }

            stack.pop();
            if (value >= 1) {
                stack.push(new Pair(pNode, value - 1));
            }
            if (cNode != null) {
                stack.add(new Pair<>(cNode, 1));
            }

        }
        return r;
    }

}
