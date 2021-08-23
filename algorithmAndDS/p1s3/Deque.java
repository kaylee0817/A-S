package p1s3;

import java.util.Date;

/**
 * Double  End queue
 * 实现方法一，需要浪费一个空间，但省略size成员变量
 * @param <E>
 */
public class Deque<E> {

    private E[] data;
    private int front, tail;

    /**
     * 构建容量为capacity的数组
     * @param capacity 可用容量
     */
    public Deque(int capacity) {
        data = (E[]) new Object[capacity + 1];
    }


    public Deque() {
        this(10);
    }

   public int getCapacity() {
        return data.length - 1;
   }


    /**
     * 在有一个白空间的情况下，在头尾指针重合时只能说明该数组为空，而不是满
     */
    public boolean isEmpty() {
        return front == tail;
    }

    public int getSize() {
        return front <= tail ? tail - front : data.length - (front - tail);
    }

    /**
     * 插队到最前面
     * @param e
     */
    public void addLast(E e) {
        if ((tail +  1) % data.length == front) {
            resize(getCapacity() * 2);
        }
        data[tail] = e;
        tail = (tail + 1) % data.length;


    }

    /**
     * 常规排队
     */
    public void addFront(E e) {
        if ((tail + 1) % data.length == front) {
            resize(getCapacity() * 2);
        }
        if (front == 0) {
            data[data.length - 1] = e;
            front = data.length -1;
        } else {
            data[front - 1] = e;
            front --;
        }
    }

    public E removeFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Try to remove from empty queue");
        }
        E ret = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        if (getSize() == getCapacity() /  4 && getCapacity() / 2 != 0) {
            resize(getCapacity() / 2);
        }
        return ret;
    }

    public E removeLast() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Try to remove from empty queue");
        }
        E ret = data[tail];
        data[tail] = null;
        if (tail == 0) {
            tail = data.length - 1;
        }  else {
            tail --;
        }
        if (getSize() == getCapacity() /  4 && getCapacity() / 2 != 0) {
            resize(getCapacity() / 2);
        }
        return ret;
    }



    public E getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Try to remove from empty queue");
        }
        return data[front];
    }

    public E getLast() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Try to remove from empty queue");
        }
        if (tail == 0) {
            return data[data.length - 1];
        } else {
            return data[tail];
        }
    }

    public void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity + 1];
        for (int i = 0; i < getSize(); i++) {
            newData[i] = data[(front + i) % data.length];
        }
        data = newData;
        front= 0;
        tail = getSize();
        newData = null;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Queue size = %d, capacity = %d\n", getSize(), getCapacity()));
        res.append("front [");
        for (int i = front; i != tail ; i = (i + 1) % data.length) {
            res.append(data[i]);
            if ((i + 1) % data.length != tail) {
                res.append("," );
            }
        }
        res.append("] tail");
        return res.toString();
    }
}
