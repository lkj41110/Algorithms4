package leetcode.other;

/**
 * 第k大的数两种方法：
 * 1.快排的思想
 * 2.堆的思想
 * 0
 * 1 , 2,
 * 3,4, 5,6 ,7,8,9,10
 */
public class Solution215_1 {
    public int findKthLargest(int[] nums, int k) {
        int len = nums.length - 1;
        for (int i = (len - 1) / 2; i >= 0; i--) {
            build(nums, i, len);
        }
        for (int i = 0; i < k - 1; i++) {
            nums[0] = nums[len--];
            build(nums, 0, len);
        }
        return nums[0];
    }

    void build(int nums[], int index, int len) {
        int left, right, j;
        while ((left = 2 * index + 1) <= len) {
            right = left + 1;
            j = left;
            if (right <= len && nums[left] < nums[right]) {
                j++;
            }
            if (nums[index] < nums[j]) {
                swap(nums, index, j);
            } else {
                break;
            }
            index = j;
        }
    }

    void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void main(String[] args) {
        Solution215_1 solution = new Solution215_1();
        int[] a = {3, 2, 1, 5, 6, 4};
        System.out.println(solution.findKthLargest(a, 2));
        int[] b = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        System.out.println(solution.findKthLargest(b, 4));
    }


}