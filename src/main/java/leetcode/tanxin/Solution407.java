package leetcode.tanxin;


import java.util.PriorityQueue;

/**
 * 1234567
 * <p>
 * f（x）=f
 */
class Solution407 {
    public int trapRainWater(int[][] heightMap) {
        int h = heightMap.length;
        if (h == 0) return 0;
        int w = heightMap[0].length;
        if (w == 0) return 0;

        // 用一个vis数组来标记这个位置有没有被访问过
        boolean[][] vis = new boolean[h][w];
        // 优先队列中存放三元组 [x,y,h] 坐标和高度
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if ((i == 0 || i == h - 1 || j == 0 || j == w - 1) && vis[i][j] == false) {
                    pq.offer(new int[]{i, j, heightMap[i][j]});
                    vis[i][j] = true;
                }
            }
        }
        int[][] f = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        int sum = 0;
        while (pq.size() > 0) {
            int[] poll = pq.poll();
            for (int i = 0; i < 4; i++) {
                int x = poll[0] + f[i][0];
                int y = poll[1] + f[i][1];
                if (x < 0 || x >= h || y < 0 || y >= w) {
                    continue;
                }
                if (vis[x][y] != true) {
                    if (poll[2] > heightMap[x][y]) {
                        sum += poll[2] - heightMap[x][y];
                        pq.offer(new int[]{x, y, poll[2]});
                    } else {
                        pq.offer(new int[]{x, y, heightMap[x][y]});
                    }
                    vis[x][y] = true;
                }
            }
        }
        return sum;
    }

    //public static void main(String[] args) {
    //    int a[][] = new int[][]{
    //            {1, 4, 3, 1, 3, 2},
    //            {3, 2, 1, 3, 2, 4},
    //            {2, 3, 3, 2, 3, 1}
    //    };
    //    Solution407 b = new Solution407();
    //    b.trapRainWater(a);
    //}
}