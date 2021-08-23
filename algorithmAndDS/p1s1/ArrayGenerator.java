package p1s1;

import java.util.Random;

public class ArrayGenerator {

    private ArrayGenerator() {
    }

    public static Integer[] generateOrderedArray(int n) {
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
        return arr;
    }

    /**
     * 生成一个随机数组
     * @param size 数组长度
     * @param bound 数组范围 [0, bound)
     * @return
     */
    public static Integer[] generateRandomArray(int size, int bound) {
        Integer[] arr = new Integer[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(bound);

        }
        return arr;
    }
}
