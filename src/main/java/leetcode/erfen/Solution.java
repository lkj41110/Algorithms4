package leetcode.erfen;

public class Solution {

    /**
     * 二分查找最普通的
     *
     * @param nums
     */
    public int test1(int nums[], int num) {
        int s = 0, e = nums.length - 1;
        while (s <= e) {
            int mid = s + (e - s) / 2;
            System.out.println("中间数  " + mid);
            if (num > nums[mid]) {
                s = mid + 1;
            } else if (num < nums[mid]) {
                e = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    /**
     * 二分查
     * 第一个相似的
     *
     * @param nums
     */
    public int test2(int nums[], int num) {
        int s = 0, e = nums.length - 1;
        while (s <= e) {
            int mid = s + (e - s) / 2;
            System.out.println("中间数  " + mid);
            if (num > nums[mid]) {
                s = mid + 1;
            } else if (num <= nums[mid]) {
                e = mid - 1;
            }
        }
        if (s < nums.length && nums[s] == num) {
            return s;
        }
        return -1;
    }

    public static void main(String[] args) {
        int a[] = {2, 7, 7, 7, 7, 7, 7, 10, 21, 168, 172, 200};
        Solution solution = new Solution();
        System.out.println("最终位置 " + solution.test2(a, 7));
    }
}