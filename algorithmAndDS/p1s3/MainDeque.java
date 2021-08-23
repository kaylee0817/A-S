package p1s3;

public class MainDeque {
    public static void main(String[] args) {
        Deque<Integer> deque = new Deque<>();
        for (int i = 0; i < 10; i++) {
            deque.addFront(i);
            System.out.println(deque);
            if(i % 3 == 1) {
                System.out.println("=== Run front remove ===");
                deque.removeFront();
                System.out.println(deque);
            }
        }
        for (int i = 0; i < 10; i++) {
            deque.addLast(i);
            System.out.println(deque);
            if (i % 3 == 1) {
                System.out.println("=== Run last remove ===");
                deque.removeLast();
                System.out.println(deque);
            }
        }
    }

}
