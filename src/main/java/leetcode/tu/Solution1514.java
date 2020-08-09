package leetcode.tu;


/**
 * 无方向的
 */
public class Solution1514 {

    /**
     * 用普通的遍历方法会超出时间限制
     */
    public double maxProbability1(int n, int[][] edges, double[] succProb, int start, int end) {
        double[] res = new double[n];
        res[start] = 1;
        dfs1(res, start, end, edges, succProb, res[start]);
        return res[end];
    }

    private void dfs1(double[] res, int start, int end, int[][] edges, double[] succProb, double sroce) {
        for (int i = 0; i < edges.length; i++) {

            if (edges[i][0] != start && edges[i][1] != start) {
                continue;
            }

            double newSroce = sroce * succProb[i];
            int x = 0;
            if (edges[i][0] == start) {
                x = 1;
            }
            if (newSroce > res[edges[i][x]]) {
                res[edges[i][x]] = newSroce;
                if (edges[i][x] != end) {
                    dfs1(res, edges[i][x], end, edges, succProb, newSroce);
                }
            }

        }

    }


    public static void main(String[] args) {
        Solution1514 solution = new Solution1514();
        int[][] a = {{0, 1}, {1, 2}, {0, 2}};
        double[] b = {0.5, 0.5, 0.2};

        System.out.println(solution.maxProbability1(3, a, b, 0, 2));
    }


}