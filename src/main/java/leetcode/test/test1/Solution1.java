package leetcode.test.test1;

/**
 * 验证 回文串
 */
class Solution1 {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int len1 = arr1.length;
        int len2 = arr2.length;
        if (len1 == 0) return 0;
        if (len2 == 0) return 0;
        int res = 0;
        for (int i = 0; i < len1; i++) {
            boolean a = true;
            for (int j = 0; j < len2; j++) {
                if (Math.abs(arr1[i] - arr2[j]) <= d) {
                    a = false;
                    break;
                }
            }
            if (a) res++;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution1 a = new Solution1();
        int[] a1 = new int[]{1,4,2,3};
        int[] a2 = {-4,-3,6,10,20,30};
        int palindrome = a.findTheDistanceValue(a1,a2,3);
        System.out.println(palindrome);
    }
}