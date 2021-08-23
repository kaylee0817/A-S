package p1s3;

/**
 *循环队列 两个指针，
 * tail 指针指向的是下一个要插入的位置，
 * front指针指向的是下一个要出队的位置。
 *  (tail + 1) % data.length == front <--队列满，浪费一个空间
 */

public interface Queue<E> {

    int getSize();
    boolean isEmpty();
    void enqueue(E e);
    E dequeue();
    E getFront();
}
