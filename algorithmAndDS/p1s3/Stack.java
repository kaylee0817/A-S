package p1s3;

public interface Stack<E> {
    int getSize();
    boolean  isEmpty();
    void push(E e);
    E pop();
    E peek();
}
