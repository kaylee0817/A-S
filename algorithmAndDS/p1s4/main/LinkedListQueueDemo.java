package p1s4.main;

import p1s4.LinkedListQueue;

public class LinkedListQueueDemo {
    public static void main(String[] args) {
        LinkedListQueue queue = new LinkedListQueue();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            System.out.println(queue);
            if (i % 3 ==2) {
                queue.dequeue();
                System.out.println(queue);
            }
        }

    }
    
}
