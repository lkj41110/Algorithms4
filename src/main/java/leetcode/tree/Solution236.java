package leetcode.tree;

import javafx.util.Pair;

import java.util.Stack;

/**
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * <p>
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * <p>
 * <p>
 * 个人想法是找出两个节点的深度，然后再找出对应的父节点
 * 例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]
 */
public class Solution236 {


    private static int flag;
    private static TreeNode temp;
    private static TreeNode temp1;
    private static int type = 0;


    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (p == q) {
            return p;
        }
        Stack<Pair<TreeNode, Integer>> stack = new Stack<>();
        stack.add(new Pair<>(root, 1));

        //判断有没有获取到第一个节点
        while (stack.size() > 0) {
            Pair<TreeNode, Integer> pair = stack.pop();
            TreeNode treeNode = pair.getKey();
            Integer value = pair.getValue();
            check(p, q, treeNode);

            TreeNode cNode = null;
            if (value == 1) {
                cNode = treeNode.left;
                stack.add(new Pair<>(treeNode, 0));
            } else {
                cNode = treeNode.right;
            }

            if (flag == 1 || flag == 2) {
                temp = treeNode;
                //保存
                if (value == 1) {
                    type = 1; //同一棵树左子树
                } else if (value == 2) {
                    type = 2; //同一棵树 右字数
                }
            } else if (flag == 3) {
                if (type == 1 || type == 2) {
                    return temp;
                }
                if (type == 3) {
                    //第一课
                    return temp1;
                }
            }

            if (flag > 0) { //已经有了，进行处理


            }

            if (cNode != null) {
                stack.add(new Pair<>(treeNode, 1));
            }
        }
        return root;

    }

    private void check(TreeNode p, TreeNode q, TreeNode treeNode) {
        if (flag == 0) {
            if (q.val == treeNode.val) {
                flag = 1;
                return;
            }
            if (p.val == treeNode.val) {
                flag = 2;
                return;

            }

        } else if (flag == 1) {
            if (q.val == treeNode.val) {
                flag = 3;
                return;
            }
        } else {
            if (p.val == treeNode.val) {
                flag = 3;
                return;

            }
        }
    }

    private static TreeNode temp3;

    //---------------递归--------
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        panduan(root, p, q);
        return temp3;
    }

    private boolean panduan(TreeNode treeNode, TreeNode p, TreeNode q) {
        if (treeNode == null) {
            return false;
        }

        boolean rFlag = panduan(treeNode.right, p, q);
        boolean lFlag = panduan(treeNode.left, p, q);

        if (rFlag && lFlag) {
            temp3 = treeNode;
            return true;
        } else if ((rFlag || lFlag) && (treeNode.val == p.val || treeNode.val == q.val)) {
            temp3 = treeNode;
            return true;
        }
        return rFlag || lFlag || treeNode.val == p.val || treeNode.val == q.val;

    }

    public static void main(String[] args) {
        Solution236 solution = new Solution236();
        TreeNode treeNode = new TreeNode(new int[]{3, 5, 1, 6, 2, 0, 8, -1, -1, 7, 4});
        solution.lowestCommonAncestor(treeNode, new TreeNode(5), new TreeNode(1));
    }

}
