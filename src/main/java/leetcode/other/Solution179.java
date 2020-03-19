package leetcode.other;


/**
 * 快排 比较方法修改
 */
public class Solution179 {
    public String largestNumber(int[] nums) {
        quickNums(nums, 0, nums.length - 1);
        StringBuffer sb = new StringBuffer();
        for (int num : nums) {
            sb.append(num);
        }
        return sb.toString();
    }

    private void quickNums(int[] nums, int s, int e) {
        if (s >= e) return;
        int temp = nums[s];
        int ts = s;
        int te = e + 1;
        while (true) {
            while (swap(temp, nums[++ts])) {
                if (ts == e) break;
            }
            while (swap(nums[--te], temp)) {
                if (te == s) break;
            }
            if (ts >= te) break;
            exch(nums, s, e);
        }
        exch(nums, s, te);
        quickNums(nums, s, ts - 1);
        quickNums(nums, ts + 1, e);
    }

    private void exch(int[] a, int i, int j) {
        int swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    private boolean swap(int a, int b) {
        int[] temp = new int[40];
        int[] temp2 = new int[40];
        int al = 0;
        while (a > 0) {
            temp[al++] = a % 10;
            a = a / 10;
        }
        int al2 = 0;
        while (b > 0) {
            temp[al2++] = b % 10;
            b = b / 10;
        }
        if (al != al2) return al > al2;
        while (al-- > 0) {
            if (temp[al] != temp2[al]) {
                return temp[al] > temp2[al];
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution179 solution = new Solution179();
        //int[] a = {3,30,34,5,9};
        int[] a = {3, 2,1};
        System.out.println(solution.largestNumber(a));

        solution.swap(1, 2);
    }


}