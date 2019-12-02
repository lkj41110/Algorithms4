package sort;

import java.util.Comparator;
import java.util.Random;

/**
 * @author luokai
 * @description:
 * @date: 2019-12-01
 * @version: 1.0
 */
public class AbstractSort {

    /**
     * 比较大小
     *
     * @param v
     * @param w
     * @return
     */
    protected static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    /**
     * 比较大小
     *
     * @param v
     * @param w
     * @return
     */
    protected static boolean less(Object v, Object w, Comparator comparator) {
        return comparator.compare(v, w) < 0;
    }

    /**
     * 对方法进行比较
     *
     * @param a
     * @param i
     * @param j
     */
    protected static void exch(Object[] a, int i, int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    protected static void exch(int[] a, int i, int j) {
        int swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }


    /**
     * 判断是否 是排序的，对调试很有作用
     *
     * @param a
     * @return
     */
    protected static boolean isSorted(Comparable[] a) {
        return isSorted(a, 0, a.length);
    }

    protected static boolean isSorted(Comparable[] a, int lo, int hi) {
        for (int i = lo + 1; i < hi; i++) {
            if (less(a[i], a[i - 1])) {
                return false;
            }
        }
        return true;
    }

    protected static boolean isSorted(Object[] a, Comparator comparator) {
        return isSorted(a, 0, a.length, comparator);
    }

    protected static boolean isSorted(Object[] a, int lo, int hi, Comparator comparator) {
        for (int i = lo + 1; i < hi; i++) {
            if (less(a[i], a[i - 1], comparator)) {
                return false;
            }
        }
        return true;
    }

    protected static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

    /**
     * 产生N个随机数用来排序
     * 小于1000
     *
     * @param N
     * @return
     */
    protected static Integer[] getRandomInput(int N) { // 使用算法1将T个长度为N的数组排序
        Random random = new Random();
        Integer[] a = new Integer[N];
        for (int i = 0; i < N; i++) {
            a[i] = random.nextInt(1000);
        }
        return a;
    }
}
