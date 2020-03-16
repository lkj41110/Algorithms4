package sort;

/**
 * 归并排序
 *
 * @author luokai
 * @description:
 * @date: 2019-12-01
 * @version: 1.0
 */
public class HeapSort extends AbstractSort {

    public void sort(int[] nums) {

    }

    public void build(int[] nums, int length) {
        int li = length << 2 + 1;
        int ri = li + 1;

        if (li > nums.length) return;
        int max = li;
        if (ri <= nums.length && nums[ri] > nums[li]) {
            max = ri;
        }
        if (nums[max] > nums[length]) {

        }

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
