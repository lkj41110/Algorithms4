package leetcode.other;


import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * -10  1  2  3  9  10
 */
public class Solution218 {

    public List<List<Integer>> getSkyline(int[][] buildings) {

        ArrayList<List<Integer>> array = new ArrayList<>();
        if (buildings.length == 0) {
            return array;
        }

        Queue<Pair<Integer, Integer>> queue = new PriorityQueue<>((a, b) -> {
            if (a.getKey() > b.getKey()) {
                return 1;
            } else if (a.getKey() < b.getKey()) {
                return -1;
            } else {
                return b.getValue() - a.getValue();
            }
        });

        for (int i = 0; i < buildings.length; i++) {
            queue.offer(new Pair<>(buildings[i][0], buildings[i][2]));
            queue.offer(new Pair<>(buildings[i][1], -buildings[i][2]));
        }

        Queue<Integer> high = new PriorityQueue<>((a, b) -> b - a);
        Pair<Integer, Integer> pair = new Pair<>(0, 0);
        high.add(0);
        while (!queue.isEmpty()) {
            Pair<Integer, Integer> poll = queue.poll();
            int x = poll.getKey();
            int y = poll.getValue();
            if (y > 0) {
                //左边部分,如果是最高的，就插入
                high.add(y);
            } else {
                //右边部分
                high.remove(-y);
            }

            Integer peek = high.peek();
            if (!peek.equals(pair.getKey())) {
                pair = new Pair<>(peek, x);
                List<Integer> list = new ArrayList<>();
                list.add(pair.getValue());
                list.add(pair.getKey());
                array.add(list);
            }
        }

        return array;
    }

    public static void main(String[] args) {
        Solution218 solution218 = new Solution218();
        //int[][] buildint = {{2, 9, 10}, {3, 7, 15}, {5, 12, 12}, {15, 20, 10}, {19, 24, 8}};
        int[][] buildint = {{0, 2, 3}, {2, 5, 3}};
        solution218.getSkyline(buildint);
    }

}