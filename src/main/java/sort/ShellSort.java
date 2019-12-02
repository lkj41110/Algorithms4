package sort;

/**
 * @author luokai
 * @description:
 * @date: 2019-12-01
 * @version: 1.0
 */
public class ShellSort extends AbstractSort {

    private ShellSort() {
    }

    /**
     * 希尔排序
     *
     * @param a the array to be sorted
     */
    public static void sort(Comparable[] a) {
        int length = a.length;
        int h = 1;

        while (h < length / 3) {
            h = 3 * h;
        }

        while (h >= 1) {
            for (int i = h; i < length; i++) {
                //h个部分有序队列
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
                    exch(a, j, j - h);
                }
            }
            h = h / 3 ;
        }
        assert isSorted(a);
    }


    /**
     * Reads in a sequence of strings from standard input; insertion sorts them;
     * and prints them to standard output in ascending order.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        Integer[] a = getRandomInput(20);
        ShellSort.sort(a);
        show(a);
    }

}
