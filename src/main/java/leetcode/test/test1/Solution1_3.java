package leetcode.test.test1;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 验证 回文串
 */
class Solution1_3 {

    public class Point implements Comparable {
        public int i;
        public int j;

        public Point(int i, int j) {
            this.i = i;
            this.j = j;
        }

        @Override
        public int compareTo(Object o) {
            Point p = (Point) o;
            if (this.i - p.i != 0) {
                return this.i - p.i > 0 ? 1 : -1;
            }
            return this.j - p.j > 0 ? 1 : -1;
        }
    }

    public int getKth(int lo, int hi, int k) {
        int[] a = new int[300000];
        a[1] = 0;
        for (int i = 2; i <= 300000; i = i * 2) {
            a[i] = a[i / 2] + 1;
        }
        ArrayList<Point> list = new ArrayList();
        for (int i = lo; i <= hi; i++) {
            list.add(new Point(dfs(a, i), i));
        }
        Collections.sort(list);
        return list.get(k - 1).j;
    }

    private int dfs(int[] a, int index) {
        if (a[index] != 0) {
            return a[index];
        }
        int r = 0;
        if (index % 2 == 0) {
            r = dfs(a, index / 2) + 1;
        } else {
            r = dfs(a, index * 3 + 1) + 1;
        }
        a[index] = r;
        return r;
    }


    public static void main(String[] args) {
        Solution1_3 a = new Solution1_3();
        //int[][] a2 = {{1, 2}, {1, 3}, {1, 8}, {2, 6}, {3, 1}, {3, 10}};
        int[][] a2 = {{2, 3}};
        int palindrome;
         palindrome = a.getKth(12, 15, 2);
        System.out.println(palindrome + "  ");
        //
        palindrome = a.getKth(1, 1, 1);
        System.out.println(palindrome + "  ");

        palindrome = a.getKth(1, 1000, 777);
        System.out.println(palindrome + "  ");
    }
}