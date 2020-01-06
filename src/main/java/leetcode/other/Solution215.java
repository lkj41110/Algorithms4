package leetcode.other;

/**
 * 第k大的数两种方法：
 * 1.快排的思想
 * 2.堆的思想
 */
public class Solution215 {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        if (n < k) {
            return 0;
        }

        return sort(nums, 0, nums.length - 1, k - 1);
    }

    int sort(int[] nums, int start, int end, int k) {
        if (start > end)
            return -1;
        int temp = nums[start];
        int t_s = start, t_e = end;
        int temp_n = start;
        while (t_s <= t_e) {
            while (temp >= nums[t_e] && t_s < t_e) {
                t_e--;
            }
            if (temp < nums[t_e]) {
                swap(nums, t_s++, t_e);
                temp_n = t_e;
            }
            while (temp < nums[t_s] && t_s < t_e) {
                t_s++;
            }
            if (temp >= nums[t_s]) {
                swap(nums, t_s, t_e--);
                temp_n = t_s;
            }
        }
        if (temp_n == k)
            return temp;
        else if (temp_n > k) {
            return sort(nums, start, temp_n - 1, k);
        } else {
            return sort(nums, temp_n + 1, end, k);
        }
    }

    void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void main(String[] args) {
        Solution215 solution = new Solution215();
        int[] a = {3, 2, 1, 5, 6, 4};
        System.out.println(solution.findKthLargest(a, 2));
        int[] b = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        System.out.println(solution.findKthLargest(b, 4));
    }


}