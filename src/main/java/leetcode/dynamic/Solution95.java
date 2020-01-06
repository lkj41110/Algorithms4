package leetcode.dynamic;

import leetcode.tree.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution95 {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0)
            return new LinkedList<>();
        return getTrees(1, n);
    }

    public List<TreeNode> getTrees(int s, int e) {
        List<TreeNode> treeNodes = new LinkedList<>();
        if (s > e) {
            treeNodes.add(null);
            return treeNodes;
        }
        for (int i = s; i <= e; i++) {
            List<TreeNode> trees1 = getTrees(s, i - 1);
            List<TreeNode> trees2 = getTrees(i + 1, e);

            for (TreeNode r : trees1) {
                for (TreeNode l : trees2) {
                    TreeNode treeNode = new TreeNode(i);
                    treeNode.right = l;
                    treeNode.left = r;
                    treeNodes.add(treeNode);
                }
            }
        }
        return treeNodes;
    }

    public static void main(String[] args) {
        Solution95 solution95 = new Solution95();

        List<TreeNode> treeNodes = solution95.generateTrees(3);
        System.out.println(treeNodes);
    }
}