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
            exch(nums, ts, te);
        }
        exch(nums, s, te);
        quickNums(nums, s, te - 1);
        quickNums(nums, te + 1, e);
    }

    private void exch(int[] a, int i, int j) {
        int swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    private boolean swap(int a, int b) {
        String order1 = a + "" + b;
        String order2 = b + "" + a;
        return order2.compareTo(order1) >= 0;
    }

    public static void main(String[] args) {
        Solution179 solution = new Solution179();
        int[] a = {1,2,3,4,5,6};
        //int[] a = {4, 31};
        System.out.println(solution.largestNumber(a));

        solution.swap(1, 2);
    }


}