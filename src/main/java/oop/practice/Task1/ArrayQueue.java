package oop.practice.Task1;

public class ArrayQueue<T> implements Queue<T> {
    private Object[] elements;
    private int front;
    private int rear;
    private int size;

    public ArrayQueue(int capacity) {
        elements = new Object[capacity];
        front = 0;
        rear = 0;
        size = 0;
    }

    @Override
    public void enqueue(T element) {
        if (size == elements.length) {
            throw new RuntimeException("Queue is full");
        }
        elements[rear] = element;
        rear = (rear + 1) % elements.length;
        size++;
    }

    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        T element = (T) elements[front];
        front = (front + 1) % elements.length;
        size--;
        return element;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }
}
