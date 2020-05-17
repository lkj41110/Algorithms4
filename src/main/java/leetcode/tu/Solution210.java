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
public class Solution210 {

    /**
     * BFS
     *
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses <= 0) {
            return new int[0];
        }

        Set<Integer> pre[] = new HashSet[numCourses];
        //存放需要的前置条件
        int[] inValue = new int[numCourses];

        for (int i = 0; i < prerequisites.length; i++) {
            int index = prerequisites[i][1];
            if (pre[index] == null) {
                pre[index] = new HashSet<>();
            }
            pre[index].add(prerequisites[i][0]);
            inValue[prerequisites[i][0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        int[] res = new int[numCourses];
        int resIndex = 0;
        for (int i=0;i<inValue.length;i++) {
            if (inValue[i] == 0) {
                queue.offer(i);
            }
        }

        while (queue.size() > 0) {
            Integer poll = queue.poll();
            res[resIndex++] = poll;

            Set<Integer> temp = pre[poll];
            if (temp == null) {
                continue;
            }
            for (Integer index : temp) {
                inValue[index]--;
                if (inValue[index] == 0) {
                    queue.add(index);
                }
            }
        }
        if (resIndex != numCourses) {
            return new int[0];
        }
        return res;
    }


    public static void main(String[] args) {
        Solution210 solution = new Solution210();
        int[][] a = new int[0][0];

        //int[] a1 = {1, 0};
        //a[0] = a1;

        System.out.println(solution.findOrder(2, a));
    }


}