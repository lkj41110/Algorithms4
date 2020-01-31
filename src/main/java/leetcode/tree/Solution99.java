package leetcode.tree;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉搜索树中的两个节点被错误地交换。
 * <p>
 * 请在不改变其结构的情况下，恢复这棵树。
 * <p>
 * 中序遍历，从小到大
 */
public class Solution99 {

    public void recoverTree(TreeNode root) {
        if (root == null) {
            return;
        }

        List<TreeNode> list = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();

        TreeNode node = root;
        int flag = 0;
        TreeNode temp1 = null, temp2 = null;
        TreeNode temp = null;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }

            TreeNode pop = stack.pop();
            if (temp != null) {
                if (flag == 0) {
                    if (pop.val < temp.val) {
                        temp1 = temp;
                        temp2 = pop;
                        flag = 1;
                    }
                } else if (flag == 1) {
                    if (pop.val < temp.val) {
                        temp2 = pop;
                    }
                }
            }
            temp = pop;
            node = pop.right;
        }

        int tempValue = temp1.val;
        temp1.val = temp2.val;
        temp2.val = tempValue;
    }

    public static void main(String[] args) {
        Solution99 solution = new Solution99();
        solution.recoverTree(new TreeNode(new int[]{1,3,-1,-1,2}));

    }
}
