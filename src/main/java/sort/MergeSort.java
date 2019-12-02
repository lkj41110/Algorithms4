package sort;

/**
 * 归并排序
 *
 * @author luokai
 * @description:
 * @date: 2019-12-01
 * @version: 1.0
 */
public class MergeSort extends AbstractSort {

    private MergeSort() {
    }

    public static void sort(Comparable[] a, int start, int end) {
        int lo = start, hi = end;
        if (lo < hi) {
            int mid = lo / 2 + hi / 2;
            sort(a, lo, mid);
            sort(a, mid + 1, hi);
            merge(a, lo, mid, hi);
        }

    }

    public static void merge(Comparable[] a, int lo, int mid, int hi) {
        Comparable[] temp = new Comparable[a.length];
        //存放到临时空间中
        for (int i = lo; i <= hi; i++) {
            temp[i] = a[i];
        }
        int i = lo, j = mid + 1;
        for (int index = lo; index <= hi; index++) {
            if (i > mid) {
                a[index] = temp[j++];
            } else if (j > hi) {
                a[index] = temp[i++];
            } else if (less(temp[j], temp[i])) {
                a[index] = temp[j++];
            } else {
                a[index] = temp[i++];
            }
        }
    }


    /**
     * Reads in a sequence of strings from standard input; insertion sorts them;
     * and prints them to standard output in ascending order.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        Integer[] a = getRandomInput(16);
        //Integer[] a = {217,723,237,310};
        MergeSort.sort(a, 0, a.length - 1);
        show(a);
        System.out.println(MergeSort.isSorted(a));
    }


}
