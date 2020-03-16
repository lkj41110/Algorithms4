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
        //int[][] a = new int[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                boolean dfs = dfs(board, word, 0, h, w, i, j);
                if (dfs) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int start, int h, int w, int i, int j) {
        if (start == word.length()) {
            return true;
        }
        if (i < 0 || i >= h || j < 0 || j >= w) {
            return false;
        }
        //if (a[i][j] == 1) {
        //    return false;
        //}
        if (board[i][j] != word.charAt(start)) {
            return false;
        }
        //a[i][j] = 1;
        char temp = board[i][j];
        board[i][j] = ' ';
        boolean flag = false;
        flag = dfs(board, word, start + 1, h, w, i, j);
        if (flag) return flag;
        flag = dfs(board, word, start + 1, h, w, i + 1, j + 1);
        if (flag) return flag;
        flag = dfs(board, word, start + 1, h, w, i - 1, j);
        if (flag) return flag;
        flag = dfs(board, word, start + 1, h, w, i, j - 1);
        if (flag) return flag;
        board[i][j] = temp;
        return flag;
    }

    public static void main(String[] args) {
        Solution79 solution = new Solution79();
        char[][] a = {{'C', 'A', 'A'}, {'A', 'A', 'A'}, {'B','C', 'D'}};
        System.out.println(solution.exist(a,"AAB"));
    }


}