package p1s4.main;

import p1s3.*;
import p1s4.LinkedList;
import p1s4.LinkedListStack;

import java.util.Random;

public class LinkedListStackDemo {


    /**
     * 测试使用两种构造方法实现的stack运行opCount个enqueue和dequeue操作所需要的时间
     * @param stack
     * @param opCount 操作enqueue和dequeue的数量
     * @return 所需要的时间，秒
     */
    private static double testStack(Stack<Integer> stack, int opCount) {
        long startTime = System.nanoTime();

        Random random = new Random();
        for (int i = 0; i < opCount; i++) {
            stack.push(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < opCount; i++) {
            stack.pop();
        }

        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;

    }
    public static void main(String[] args) {
        int opCount = 100000000;
        ArrayStack<Integer> arrayStack = new ArrayStack<>();
        double time1 = testStack(arrayStack, opCount);
        System.out.println("arrayStack, time:      " + time1 + "s");

        LinkedListStack<Integer> linkedListStack = new LinkedListStack<>();
        double time2 = testStack(linkedListStack, opCount);
        System.out.println("linkedListStack, time: " + time2 + "s");
    }
}
