package leetcode.tree;

/**
 * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 * <p>
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 */
public class Solution1448 {

    public int findTheLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }

        int[] pos = new int[32];
        for (int i = 0; i < 32; i++) {
            pos[i] = -1;
        }

        int status = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == 'a') {
                status = status ^ 1;
            } else if (ch == 'e') {
                status = status ^ 1 << 1;
            } else if (ch == 'i') {
                status = status ^ 1 << 2;
            } else if (ch == 'o') {
                status = status ^ 1 << 3;
            } else if (ch == 'u') {
                status = status ^ 1 << 4;
            }

            if (pos[status] == -1) {
                pos[status] = i;
            } else {
                max = Math.max(max, i - pos[status] + 1);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(1^1);
        System.out.println(1^0);
        System.out.println(0^0);
    }
}
