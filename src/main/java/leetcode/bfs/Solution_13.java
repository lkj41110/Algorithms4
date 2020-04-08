package leetcode.bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 广搜， 多源发散
 */
public class Solution_13 {
    public int movingCount(int m, int n, int k) {
        if (k == 0) return 1;

        int[][] d = {{0, 1}, {1, 0}};

        Queue<int[]> queue = new LinkedList<>();
        int[][] mark = new int[m][n];

        queue.offer(new int[]{0, 0});
        int max = 1;
        mark[0][0] = 1;
        while (queue.size() >= 0) {
            int[] poll = queue.poll();
            for (int i = 0; i < 2; i++) {
                int x = poll[0] + d[i][0];
                int y = poll[1] + d[i][1];
                if (x < 0 || x >= m || y < 0 || y >= n) continue;

                if (mark[x][y] == 0) {
                    boolean check = check(x, y, k);
                    if (check) {
                        queue.offer(new int[]{x, y});
                        max++;
                    }
                    mark[x][y] = 1;
                }
            }
        }
        return max;
    }

    private boolean check(int x, int y, int k) {
        int sum = 0;
        while (x > 0) {
            sum += x % 10;
            x = x / 10;
        }
        while (y > 0) {
            sum += y % 10;
            y = y / 10;
        }
        if (sum > k) return false;
        return true;
    }
}