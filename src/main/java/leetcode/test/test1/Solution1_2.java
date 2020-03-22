package leetcode.test.test1;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 验证 回文串
 */
class Solution1_2 {
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

    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        ArrayList<Point> list = new ArrayList<>();
        for (int i = 0; i < reservedSeats.length; i++) {
            list.add(new Point(reservedSeats[i][0], reservedSeats[i][1]));
        }
        Collections.sort(list);
        Point temp = null;
        int res = 0;
        int le = 0;
        for (int i = 0; i < list.size(); i++) {
            Point p = list.get(i);
            if (temp == null) {
                le++;
                res += a(0, p.j);
                temp = p;
                continue;
            } else if (temp.i != p.i) {
                //res += (10 - temp.j) / 4; //上一层
                res += a(temp.j, 11); //上一层
                //下一层
                le++;
                res += a(0, p.j);
                temp = p;
                continue;
            } else if (p.j - temp.j - 1 >= 4) {
                res = res + a(temp.j, p.j);
                temp = p;
            }
            temp = p;
        }
        res += a(temp.j, 11); //上一层
        if (n - le > 0) {
            res += 2 * (n - le);
        }
        return res;
    }

    private int a(int a, int b) {
        if (b <= 5) return 0;
        if (b == 6 && a <= 1) return 1;
        if (b == 7 && a <= 1) return 1;
        if (b == 8 && a <= 3) return 1;
        if (b == 9 && a <= 3) return 1;
        if (b >= 10 && a <= 1) return 2;
        if (b >= 10 && a <= 5) return 1;
        return 0;
    }


    public static void main(String[] args) {
        Solution1_2 a = new Solution1_2();
        //int[][] a2 = {{1, 2}, {1, 3}, {1, 8}, {2, 6}, {3, 1}, {3, 10}};
        int[][] a2 = {{2, 3}};
        int palindrome = a.maxNumberOfFamilies(3, a2);
        System.out.println(palindrome + "  ");

        a2 = new int[][]{{2, 1}, {1, 8,}, {2, 6}};
        palindrome = a.maxNumberOfFamilies(2, a2);
        System.out.println(palindrome + "  ");
    }
}