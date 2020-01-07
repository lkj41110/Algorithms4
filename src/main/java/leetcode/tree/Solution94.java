package leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author luokai
 * @description:
 * @date: 2019/2/28
 * @version: 1.0
 *
 *
 * 中序遍历 （非递归算法）
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 *
 *
 * 输出: [1,3,2]
 */
public class Solution94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> r = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode node = root;
        //do {
        //    //
        //    while (node.left != null) {
        //        queue.addLast(node.left);
        //        node = node.left;
        //    }
        //    //打印
        //    node = queue.pollLast();
        //    r.add(node.val);
        //    if (node.right != null) {
        //        node = node.right;
        //    } else {
        //        node = queue.pollLast();
        //        r.add(node.val);
        //    }
        //} while (node!=null);


        while (node != null || !queue.isEmpty()) {
            while (node != null) {
                queue.push(node);
                node = node.left;
            }
            node = queue.pop();
            r.add(node.val);
            node = node.right;
        }
        return r;
    }

    public static void main(String[] args) {
        Solution94 solution = new Solution94();
        List<Integer> integers = solution.inorderTraversal(new TreeNode(new int[]{1,2, 3, -1,4,5,6}));
        //solution.constructMaximumBinaryTree(new int[]{3, 2, 1, 6, 0, 5});
    }
}
