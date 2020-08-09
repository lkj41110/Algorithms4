package leetcode.tu;


import java.util.LinkedList;
import java.util.List;

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

    /**
     * 邻接表
     */
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        double[] res = new double[n];
        List<int[]>[] lists = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            lists[i] = new LinkedList<>();
        }
        for (int i = 0; i < edges.length; i++) {
            int[] temp1 = {edges[i][1], i};
            lists[edges[i][0]].add(temp1);

            int[] temp2 = {edges[i][0], i};
            lists[edges[i][1]].add(temp2);
        }
        res[start] = 1;
        dfs1(res, start, end, lists, succProb, res[start]);
        return res[end];
    }

    private void dfs1(double[] res, int start, int end, List<int[]>[] lists, double[] succProb, double sroce) {
        List<int[]> list = lists[start];

        for (int i = 0; i < list.size(); i++) {
            int[] ints = list.get(i);

            double newSroce = sroce * succProb[ints[1]];
            if (newSroce < 1e-5) {
                continue;
            }
            if (newSroce > res[ints[0]]) {

                res[ints[0]] = newSroce;
                if (ints[0] != end) {
                    dfs1(res, ints[0], end, lists, succProb, newSroce);
                }
            }

        }

    }


    public static void main(String[] args) {
        Solution1514 solution = new Solution1514();
        int[][] a = {{0, 1}, {1, 2}, {0, 2}};
        double[] b = {0.5, 0.5, 0.2};

        System.out.println(solution.maxProbability(3, a, b, 0, 2));
    }


}