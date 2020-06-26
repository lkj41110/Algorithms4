package leetcode.tu;


import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 拓扑排序
 * DFS
 * <p>
 * BFS
 */
public class Solution207 {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses == 0) {
            return true;
        }
        int[] preValue = new int[numCourses];
        Set<Integer>[] next = new HashSet[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            preValue[prerequisites[i][0]]++;
            if (next[prerequisites[i][1]] == null) {
                next[prerequisites[i][1]] = new HashSet<>();
            }
            next[prerequisites[i][1]].add(prerequisites[i][0]);
        }

        Queue<Integer> queue = new LinkedList();
        for (int i = 0; i < numCourses; i++) {
            if (preValue[i] == 0) {
                queue.add(i);
            }
        }
        while (queue.size() > 0) {
            Integer poll = queue.poll();
            if (next[poll] == null) {
                continue;
            }
            for (Integer nextValue : next[poll]) {
                preValue[nextValue]--;
                if (preValue[nextValue] == 0) {
                    queue.add(nextValue);
                }
            }
        }
        for (int i = 0; i < numCourses; i++) {
            if (preValue[i] != 0) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        Solution207 solution = new Solution207();
        int[][] a = {{1, 0}};

        //int[] a1 = {1, 0};
        //a[0] = a1;

        System.out.println(solution.canFinish(2, a));
    }


}