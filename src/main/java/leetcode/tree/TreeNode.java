package leetcode.tree;

import java.util.LinkedList;

/**
 * @author luokai
 * @description:
 * @date: 2019/2/28
 * @version: 1.0
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    TreeNode(Integer x) {
        val = x;
    }

    public TreeNode(int x) {
        val = x;
    }

    public TreeNode(int[] num) {
        //[1,null,0,0,1]
        if (num.length == 0)
            return;
        LinkedList<TreeNode> l = new LinkedList();
        this.val = num[0];
        l.add(this);
        int i = 1;
        while (l.size() > 0) {
            TreeNode pop = l.pop();
            if (pop != null) {
                if (num[i] == -1) {
                    pop.left = null;
                } else {
                    pop.left = new TreeNode(num[i]);
                    l.add(pop.left);
                }
                i++;
                if (i >= num.length)
                    return;
                if (num[i] == -1) {
                    pop.right = null;
                } else {
                    pop.right = new TreeNode(num[i]);
                    l.add(pop.right);
                }
                i++;
                if (i >= num.length)
                    return;
            }
        }
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                '}';
    }
}
