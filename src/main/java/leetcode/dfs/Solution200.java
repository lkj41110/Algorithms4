package leetcode.dfs;

/**
 * 深搜
 */
public class Solution200 {

    public int numIslands(char[][] grid) {
        int h = grid.length;
        if (h == 0) {
            return 0;
        }
        int w = grid[0].length;
        if (w == 0) {
            return 0;
        }
        int[][] mark = new int[h][w];
        int num = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (mark[i][j] == 1) {
                    continue;
                }

                if (grid[i][j] == '1') {
                    num++;
                    dfs(grid, mark, h, w, i, j);
                } else {
                    mark[i][j] = 1;
                }
            }

        }
        return num;
    }

    private void dfs(char[][] board, int[][] mark, int h, int w, int i, int j) {

        if (i < 0 || i >= h || j < 0 || j >= w) {
            return;
        }
        if (mark[i][j] == 1) {
            return;
        }
        mark[i][j] = 1;
        if (board[i][j] == '0') {
            return;
        }
        dfs(board, mark, h, w, i - 1, j);
        dfs(board, mark, h, w, i + 1, j);
        dfs(board, mark, h, w, i, j - 1);
        dfs(board, mark, h, w, i, j + 1);

    }

    public static void main(String[] args) {
        //Solution79 solution = new Solution79();
        //char[][] a = {{'C', 'A', 'A'}, {'A', 'A', 'A'}, {'B','C', 'D'}};
        //System.out.println(solution.exist(a,"AAB"))

        System.out.println('z' - 'A');
        System.out.println('A' - 'A');


        ;
    }


}