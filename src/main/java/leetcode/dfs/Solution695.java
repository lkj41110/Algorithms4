package leetcode.dfs;

import java.util.Stack;

/**
 * 最小路径
 * 动态规划
 */
public class Solution695 {
    class P {
        int x;
        int y;

        public P(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "P{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

    public int maxAreaOfIsland(int[][] grid) {
        int[][] f = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int h = grid.length;
        if (h == 0) {
            return 0;
        }
        int w = grid[0].length;
        if (w == 0) {
            return 0;
        }
        Stack<P> stack = new Stack<>();
        int max = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (grid[i][j] == 0) {
                    continue;
                }

                //stack 深搜索
                stack.push(new P(i, j));
                grid[i][j] = 0;
                int tempMax = 0;
                while (stack.size() > 0) {
                    P pop = stack.pop();
                    tempMax++;
                    for (int z = 0; z < 4; z++) {
                        int x = pop.x + f[z][0];
                        int y = pop.y + f[z][1];
                        if (x >= 0 && x < h && y >= 0 && y < w && grid[x][y] != 0) {
                            grid[x][y] = 0;
                            stack.push(new P(x, y));
                        }
                    }
                }
                max = Math.max(max, tempMax);
            }
        }
        return max;
    }

}