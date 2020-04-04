package leetcode.bisai;

//package leetcode.bisai;
//
///**
// * 广搜， 多源发散
// */
public class Solution1_4 {
    public boolean checkOverlap(int radius, int x_center, int y_center, int x1, int y1, int x2, int y2) {
        //圆心在里面
        if (x_center >= x1 && x_center <= x2 && y_center >= y1 && y_center <= y2) {
            return true;
        }
        int x = (x1 + x2) / 2;
        int y = (y1 + y2) / 2;
        for (int i = x1; i <= x2; i++) {
            boolean check = check(i, y1, x_center, y_center, radius);
            if (check) return true;
            check = check(i, y2, x_center, y_center, radius);
            if (check) return true;

        }
        for (int i = y1; i <= y2; i++) {
            boolean check = check(x1, i, x_center, y_center, radius);
            if (check) return true;
            check = check(x2, i, x_center, y_center, radius);
            if (check) return true;

        }
        return false;

    }

    private boolean check(int x, int y, int x_c, int y_c, int r) {
        if ((x - x_c) * (x - x_c) + (y - y_c) * (y - y_c) <= r * r) return true;
        else return false;
    }

    public static void main(String[] args) {
        Solution1_4 s = new Solution1_4();
        System.out.println(s.checkOverlap(1, 0, 0, 1, -1, 3, 1));
        System.out.println(s.checkOverlap(4, 102, 50, 0, 0, 100, 100));
        System.out.println(s.checkOverlap(2, 2, 1, 4, 1, 5, 5));
    }
}