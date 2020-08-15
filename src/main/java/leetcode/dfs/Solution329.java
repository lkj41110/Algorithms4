package leetcode.dfs;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 深搜
 * 输入: nums =
 * [
 * [9,9,4],
 * [6,6,8],
 * [2,1,1]
 * ]
 */
public class Solution329 {
    public int longestIncreasingPath(int[][] matrix) {
        int h = matrix.length;
        if (h == 0) {
            return 0;
        }
        int w = matrix[0].length;
        if (w == 0) {
            return 0;
        }

        Queue<int[]> qu = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                int[] index = {matrix[i][j], i, j};
                qu.add(index);
            }
        }


        int[][] value = new int[h][w];
        int max = 0;
        while (qu.size() > 0) {
            int[] poll = qu.poll();
            int x = poll[1];
            int y = poll[2];
            if (value[x][y] != 0) {
                continue;
            }

            max = Math.max(dfs(x, y, value, h, w, matrix), max);

        }
        return max;

    }

    private int dfs(int x, int y, int[][] value, int h, int w, int[][] matrix) {
        int[][] f = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int max = 1;
        for (int i = 0; i < 4; i++) {
            int x2 = x + f[i][0];
            int y2 = y + f[i][1];
            if (x2 < 0 || x2 >= h || y2 < 0 || y2 >= w) {
                continue;
            }
            if (matrix[x][y] >= matrix[x2][y2]) {
                continue;
            }
            if (value[x2][y2] != 0) {
                max = Math.max(max, value[x2][y2] + 1);
            } else {
                int temp = dfs(x2, y2, value, h, w, matrix);
                max = Math.max(max, temp + 1);
            }

        }
        value[x][y] = max;
        return value[x][y];
    }

    public static void main(String[] args) {
        Solution329 so = new Solution329();
        //int[][] a = {{9, 9, 4}, {6, 6, 8}, {2, 1, 1}};
        int[][] a = {{1, 2}};
        System.out.println(so.longestIncreasingPath(a));
    }
}