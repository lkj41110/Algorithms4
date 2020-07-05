package leetcode.erfen;

/**
 * 矩形的二分查找
 */
public class Solution378 {
    public int kthSmallest(int[][] matrix, int k) {
        int h = matrix.length;
        int min = matrix[0][0];
        int max = matrix[h - 1][h - 1];

        while (min < max) {
            int mid = (min + max) / 2;
            if (!check(matrix, mid, k, h)) {
                min = mid + 1;
            } else {
                //太大
                max = mid;
            }

        }
        return min;
    }

    private boolean check(int[][] mat, int mid, int k, int h) {
        int d_i = h - 1;
        int d_j = 0;
        int sum = 0;
        while (d_j < h && d_i >= 0) {
            if (mat[d_i][d_j] <= mid) {
                sum += d_i + 1;
                d_j++;
            } else {
                d_i--;
            }
        }

        return sum >= k;
    }
}