package leetcode.dfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 深搜
 */
public class Solution63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        if (m == 0) return 0;
        int n = obstacleGrid[0].length;
        if (n == 0) return 0;

        Queue<int[]> queue = new LinkedList<>();
        int[] first = {0, 0};
        int[][] a = new int[m][n];
        if (obstacleGrid[0][0] == 1) {
            queue.offer(first);
            a[0][0] = 1;
        }

        while (queue.size() > 0) {
            int[] poll = queue.poll();
            int x = poll[0];
            int y = poll[1];
            if (x + 1 < m && y < n && obstacleGrid[x + 1][y] == 0) {
                if (a[x + 1][y] == 0) {
                    int[] temp = {x + 1, y};
                    queue.offer(temp);
                }
                a[x + 1][y] = a[x + 1][y] + a[x][y];
            }
            if (x < m && y + 1 < n && obstacleGrid[x][y + 1] == 0) {
                if (a[x][y + 1] == 0) {
                    int[] temp = {x, y + 1};
                    queue.offer(temp);
                }
                a[x][y + 1] = a[x][y + 1] + a[x][y];
            }
        }

        return a[m - 1][n - 1];
    }

    public static void main(String[] args) {
        Solution63 so = new Solution63();
        int[][] a = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        int i = so.uniquePathsWithObstacles(a);
        System.out.println(i);
    }
}