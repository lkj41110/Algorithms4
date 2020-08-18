package leetcode.bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 广搜， 多源发散
 */
public class Solution1162 {

    public int maxDistance(int[][] grid) {
        int[][] d = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        int h = grid.length;
        if (h == 0) return 0;
        int w = grid.length;
        if (w == 0) return 0;
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (grid[i][j] == 1) {
                    queue.add(new int[]{i, j});
                }
            }
        }
        int max = 0;
        while (queue.size() >= 0) {
            int[] poll = queue.poll();
            for (int i = 0; i < 4; i++) {
                int x = poll[0] + d[i][0];
                int y = poll[1] + d[i][1];
                if (x < 0 || x >= h || y < 0 || y >= w) continue;
                if (grid[x][y] == 0) {
                    grid[x][y] = grid[poll[0]][poll[1]] + 1;
                    queue.add(new int[]{x, y});
                    max = Math.max(max, grid[x][y]);
                }
            }
        }
        return max - 1;
    }

}