package p1s2.sortByInsertion;

import p1s1.ArrayGenerator;
import p1s2.selectionSort.SortingHelper;

import java.util.Arrays;

/**
 * 对于完全有序的数组，InsertionSort是O(n)级别
 */
public class InsertionSort {

    private InsertionSort() {
    }

    /**
     * InsertionSort
     * 通过翻转呈现
     * @param arr
     * @param <E>
     */
    public static <E extends Comparable<E>> void sort(E[] arr) {

        for (int i = 0; i < arr.length; i++) {

            //将arr[i]插入到合适的位置
            /*for (int j = i; j > 0; j--) {
                if (arr[j].compareTo(arr[j-1]) < 0) {
                    swap(arr, j, j-1);
                } else break;
            }*/
            for (int j = i; j > 0 && arr[j].compareTo(arr[j-1]) < 0; j--) {
                swap(arr, j, j-1);
            }

        }
    }

    /**
     * InsertionSort2
     * arr[0,i)已排序 [i,0)未排序
     * @param arr
     * @param <E>
     */
    public static <E extends Comparable<E>> void sort2(E[] arr) {
        for (int i = 0; i < arr.length; i++) {

            //将arr[i]插入到合适的位置
            E t = arr[i];
            int j;
            for (j = i; j > 0 && t.compareTo(arr[j -1]) < 0; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = t;
        }
    }

    /**
     * InsertionSort3
     * arr[0,i)未排序 [i,0)已排序
     * @param arr
     * @param <E>
     */
    public static <E extends Comparable<E>> void sort3(E[] arr) {
        for (int i = arr.length - 1; i > -1 ; i--) {
            E t =arr[i];
            int j;
            for (j = i; j + 1 < arr.length && t.compareTo(arr[j + 1]) > 0; j++) {
                arr[j] = arr[j + 1];
            }
            arr[j] = t;
        }
    }


    /**
     * 每次交换是三次操作
     * @param arr
     * @param i
     * @param j
     * @param <E>
     */
    private static <E> void swap(E[] arr, int i, int j) {
        E t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {

        int[] dataSize = {1000, 10000, 100000};
        for (int size : dataSize) {
            System.out.println("Random Array: ");

            Integer[] arr = ArrayGenerator.generateRandomArray(size, size);
            Integer[] arrCopy = Arrays.copyOf(arr, arr.length);

            SortingHelper.sortTest("InsertionSort3", arr);
            SortingHelper.sortTest("SelectionSort", arrCopy);

            System.out.println();
            System.out.println("Ordered Array: ");

            arr = ArrayGenerator.generateOrderedArray(size);
            arrCopy = Arrays.copyOf(arr, arr.length);

            SortingHelper.sortTest("InsertionSort3", arr);
            SortingHelper.sortTest("SelectionSort", arrCopy);
            System.out.println();
        }
    }
}
