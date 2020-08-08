package leetcode.tu;


import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 *
 */
public class Solution802 {

    public List<Integer> eventualSafeNodes(int[][] graph) {
        int h = graph.length;
        if (h == 0) {
            return new LinkedList<>();
        }

        //int a[][] = new int[h][h];

        Map<Integer, Set<Integer>> map = new HashMap<>();
        int ruDu[] = new int[h];
        Set<Integer> ruDu1 = new HashSet<>();

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < h; i++) {

            for (int j = 0; j < graph[i].length; j++) {
                ruDu1.add(graph[i][j]);
                Set<Integer> integers = map.get(graph[i][j]);
                if (integers == null) {
                    integers = new HashSet<>();
                    map.put(graph[i][j], integers);
                }
                integers.add(i);
            }

            ruDu[i] = ruDu1.size();
            if (graph[i].length == 0) {
                queue.add(i);
            }
            ruDu1.clear();
        }
        while (queue.size() > 0) {
            Integer poll = queue.poll();
            //入度Set
            Set<Integer> integers = map.get(poll);
            if (integers == null) {
                continue;
            }
            for (Integer in : integers) {
                ruDu[in]--;
                if (ruDu[in] == 0) {
                    queue.add(in);
                }
            }
        }

        List<Integer> res = new LinkedList<>();

        for (int i = 0; i < h; i++) {
            if (ruDu[i] == 0) {
                res.add(i);
            }
        }

        return res;
    }


    public static void main(String[] args) {
        Solution802 solution = new Solution802();
        int[][] a = {{1, 2}, {2, 3}, {5}, {0}, {5}, {}, {}};
        //[[1,2],[2,3],[5],[0],[5],[],[]]

        //int[] a1 = {1, 0};
        //a[0] = a1;

        System.out.println(solution.eventualSafeNodes((a)));
    }


}