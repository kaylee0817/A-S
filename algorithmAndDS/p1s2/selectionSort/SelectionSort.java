package p1s2.selectionSort;


import p1s1.ArrayGenerator;

/**
 * 先把最小的找出来，最后依次顺序
 */
public class SelectionSort {
    private SelectionSort() {
    }

    public static <E extends Comparable<E>> void sort(E[] arr) {

        //arr[0...i) 是有序的， arr[i...n)是无序的
        for (int i = 0; i < arr.length; i++) {
            //select arr[i...n) min value's index 处理循环不变量的其余部分
            int minIndex = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j].compareTo(arr[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
        }
    }

    public static <E extends Comparable<E>> void sort2(E[] arr) {
        //arr[i...n)已排序 arr[0...i)未排序 循环不变量, [0...i)未排序[i...n)已排序，循环不变量，倒置
        for (int i = arr.length - 1; i > -1; i--) {
            int maxIndex = i;
            for (int j = i; j > -1 ; j--) {
                if (arr[j].compareTo(arr[maxIndex]) > 0) {
                    maxIndex = j;
                }
            }
            swap(arr, i, maxIndex);
        }
    }

    private static <E> void swap(E[] arr, int i, int j) {
        E t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        /*int n = 10000;
        Integer[] arr = ArrayGenerator.generateRandomArray(n, n);*/

       /* long startTime = System.nanoTime();
        SelectionSort.sort(arr);
        long endTime = System.nanoTime();

        double time = (endTime - startTime) / 1000000000.0;
        if (!SortingHelper.isSorted(arr)) {
            throw new RuntimeException("Selection failed");
        }
        System.out.println(time + " s");*/



        /*for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();*/

       /* Student[] students = {new Student("Tom", 88),
                              new Student("Jerry", 89),
                              new Student("Jack", 90)};
        SelectionSort.sort(students);
        for(Student student  : students) {
            System.out.println(student.toString());
        }*/
        int[] dataSize = {1000, 10000, 100000};
        for (int size : dataSize) {
            Integer[] arr = ArrayGenerator.generateRandomArray(size, size);
            SortingHelper.sortTest("SelectionSort", arr);
        }
    }
}
