package leetcode.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 * <p>
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 */
public class Solution102 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        List<TreeNode> temp = Arrays.asList(root);
        do {
            List<Integer> valueLIst = new ArrayList<>();
            for (TreeNode treeNode : temp) {
                valueLIst.add(treeNode.val);
            }
            list.add(valueLIst);

            List<TreeNode> temp1 = new ArrayList<>();
            for (TreeNode node1 : temp) {
                if (node1.left != null) {
                    temp1.add(node1.left);
                }
                if (node1.right != null) {
                    temp1.add(node1.right);
                }
            }
            temp = temp1;
        }
        while (temp.size() > 0);
        return list;
    }

    /**
     * 103 锯齿遍历
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder1(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        List<TreeNode> temp = Arrays.asList(root);
        boolean flag = true;
        do {
            List<Integer> valueLIst = new ArrayList<>();
            if (flag) {
                for (TreeNode treeNode : temp) {
                    valueLIst.add(treeNode.val);
                }
            } else {
                for (int i = temp.size() - 1; i >= 0; i--) {
                    valueLIst.add(temp.get(i).val);
                }
            }
            flag = !flag;
            list.add(valueLIst);

            List<TreeNode> temp1 = new ArrayList<>();
            for (TreeNode node1 : temp) {
                if (node1.left != null) {
                    temp1.add(node1.left);
                }
                if (node1.right != null) {
                    temp1.add(node1.right);
                }
            }
            temp = temp1;
        }
        while (temp.size() > 0);
        return list;
    }
}
