package leetcode.other;


/**
 * 堆排序
 *
 */
public class Solution40 {

    /**
     * 小根堆 k logN
     *
     * @param arr
     * @param k
     * @return
     */
    public int[] getLeastNumbers(int[] arr, int k) {
        int[] res = new int[k];
        if (k == 0) return res;

        int len = arr.length;
        for (int i = (len + 1) / 2; i >= 0; i--) {
            heap(arr, i, arr.length - 1);
        }
        res[0] = arr[0];
        for (int i = 1; i < k; i++) {
            arr[0] = arr[len - i];
            heap(arr, 0, arr.length - 1 - i);
            res[i] = arr[0];
        }
        return res;
    }

    private void heap(int[] arr, int s, int e) {
        int index = s;
        while (index <= e) {
            int l = index * 2 + 1;
            int r = l+1;
            if (l >e) {
                return;
            }
            int min = arr[l];
            int temp = l;
            if (r <= e && arr[l] > arr[r]) {
                min = arr[r];
                temp = r;
            }
            if (min < arr[index]) {
                swap(arr, temp, index);
                index = temp;
            } else {
                return;
            }

        }
    }


    public int[] getLeastNumbers2(int[] arr, int k) {
        int[] res = new int[k];
        if (k == 0) return res;
        for (int i = 0; i < k; i++) {
            res[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= res[0]) continue;

            res[0] = arr[i];

            int index = 0;
            while (index < k) {
                int l = index * 2 + 1;
                int r = l + 1;
                if (l >= k) {
                    break;
                }
                int min = res[l];
                int temp = l;
                if (r < k && res[l] < res[r]) {
                    min = res[r];
                    temp = r;
                }
                if (min > res[index]) {
                    swap(res, temp, index);
                    index = temp;
                } else {
                    break;
                }

            }
        }
        return res;
    }


    private void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }


    public static void main(String[] args) {
        Solution40 solution = new Solution40();
        int[] a = {0, 0, 1, 2, 4, 2, 2, 3, 1, 4};
        int[] leastNumbers = solution.getLeastNumbers2(a, 8);
    }


}