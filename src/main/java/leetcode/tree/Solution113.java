package leetcode.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 * <p>
 * dfs 深搜
 */
public class Solution113 {

    class Pair<T> {
        private T key;
        private Integer type;
        private Integer value;

        public Pair(T key, Integer type, Integer value) {
            this.key = key;
            this.type = type;
            this.value = value;
        }

        public T getKey() {
            return key;
        }

        public void setKey(T key) {
            this.key = key;
        }

        public Integer getType() {
            return type;
        }

        public void setType(Integer type) {
            this.type = type;
        }

        public Integer getValue() {
            return value;
        }

        public void setValue(Integer value) {
            this.value = value;
        }
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        Stack<Pair<TreeNode>> stack = new Stack<>();
        Pair<TreeNode> node = new Pair<>(root, 2, root.val);
        stack.push(node);
        while (!stack.isEmpty()) {
            Pair<TreeNode> pop = stack.pop();

            Integer type = pop.getType();
            TreeNode treeNode = pop.getKey();
            TreeNode nNode = null;
            if (type == 2) {
                nNode = treeNode.left;
                stack.push(new Pair<>(treeNode, type - 1, pop.getValue()));

            } else if (type == 1) {
                nNode = treeNode.right;
                stack.push(new Pair<>(treeNode, type - 1, pop.getValue()));
            } else if (type == 0) {
                //nNode 为空 代表，已经在叶子节点
                if (pop.getValue() == sum && treeNode.right == null && treeNode.left == null) {
                    List<Integer> list1 = getList(stack, treeNode);
                    list.add(list1);
                }
            }

            if (nNode != null) {
                stack.push(new Pair<>(nNode, 2, pop.getValue() + nNode.val));
            }

        }
        return list;
    }

    private List<Integer> getList(Stack<Pair<TreeNode>> stack, TreeNode treeNode) {
        List<Integer> list = new ArrayList<>();

        if (stack != null && stack.size() > 0) {
            for (int i = 0; i < stack.size(); i++) {
                Pair<TreeNode> treeNodePair = stack.get(i);
                list.add(treeNodePair.getKey().val);
            }
        }
        list.add(treeNode.val);
        return list;
    }

}