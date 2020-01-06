package leetcode.other;


/**
 * 假设有n个数
 */
public class Solution338 {

    public int[] countBits(int num) {
        int[] r = new int[num + 1];
        r[0] = 0;
        if (num == 0)
            return r;
        int temp_n = 1;

        while (temp_n <= num) {
            int m = temp_n;
            for (int i = 0; i < m&&temp_n<=num; i++) {
                r[temp_n++] = r[i] + 1;
            }
        }
        return r;
    }


    public static void main(String[] args) {
        Solution338 su = new Solution338();
        int[] a = new int[]{1, 2, 3};
        int[] subsets = su.countBits(5);
        System.out.println(subsets);
    }


}