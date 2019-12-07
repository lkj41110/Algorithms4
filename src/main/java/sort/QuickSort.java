package sort;

/**
 * 我自己实现的
 *
 * @author luokai
 * @description:
 * @date: 2019-12-01
 * @version: 1.0
 */
public class QuickSort extends AbstractSort {

    private QuickSort() {
    }

    /**
     * 快速排序
     */
    public static void sort(Comparable[] a) {
        sort(a, 0, a.length - 1);
    }

    public static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int index = partition(a, lo, hi);
        sort(a, lo, index - 1);
        sort(a, index + 1, hi);
    }

    private static int partition(Comparable[] a, int lo, int hi) {
        Comparable temp = a[lo];
        int i = lo, j = hi;
        while (i < j) {
            while (less(temp, a[j])) {
                j--;
            }
            if (i >= j) {
                break;
            }
            exch(a, i++, j);
            while (less(a[i], temp)) {
                i++;
            }
            if (i >= j) {
                break;
            }
            exch(a, i, j--);
        }
        return i;
    }

    /**
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        Integer[] a = getRandomInput(20);
        QuickSort.sort(a);
        show(a);
        assert QuickSort.isSorted(a);
        System.out.println(QuickSort.isSorted(a));
    }

}
