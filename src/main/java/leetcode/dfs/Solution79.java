package leetcode.dfs;

/**
 * 深搜
 */
public class Solution79 {
    public boolean exist(char[][] board, String word) {
        int h = board.length;
        if (h == 0) {
            return false;
        }
        int w = board[0].length;
        if (w == 0) {
            return false;
        }
        int[][] a = new int[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                boolean dfs = dfs(board, word, 0, h, w, a, i, j);
                if (dfs) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int start, int h, int w, int[][] a, int i, int j) {
        if (start == word.length()) {
            return true;
        }
        if (i < 0 || i >= h || j < 0 || j >= w) {
            return false;
        }
        if (a[i][j] == 1) {
            return false;
        }
        if (board[i][j] != word.charAt(start)) {
            return false;
        }
        a[i][j] = 1;
        boolean flag = false;
        flag = dfs(board, word, start + 1, h, w, a, i, j);
        if (flag) return flag;
        flag = dfs(board, word, start + 1, h, w, a, i + 1, j + 1);
        if (flag) return flag;
        flag = dfs(board, word, start + 1, h, w, a, i - 1, j);
        if (flag) return flag;
        flag = dfs(board, word, start + 1, h, w, a, i, j - 1);
        if (flag) return flag;
        a[i][j] = 0;
        return flag;
    }

    public static void main(String[] args) {
        Solution79 solution = new Solution79();
        int[][] a = {{1, 1, 0, 0, 0}, {1, 1, 0, 0, 0}, {0, 0, 0, 1, 1}, {0, 0, 0, 1, 1}};
        System.out.println(solution.exist(a));
    }


}