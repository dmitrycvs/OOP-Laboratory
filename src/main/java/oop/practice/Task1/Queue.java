package oop.practice.Task1;

public class Queue<T> implements IQueue<T> {
    private T[] queue;
    private int front;
    private int rear;
    private int size;
    private final int capacity;

    public Queue() {
        this(20);
    }

    public Queue(int capacity) {
        this.capacity = capacity;
        this.queue = (T[]) new Object[capacity];
        this.front = 0;
        this.rear = 0;
        this.size = 0;
    }

    @Override
    public void enqueue(T element) {
        if (size == capacity) {
            System.out.println("Queue is full");
            return;
        }
        queue[rear] = element;
        rear = (rear + 1) % capacity;
        size++;
    }

    @Override
    public T dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return null;
        }
        T removedElement = queue[front];
        front = (front + 1) % capacity;
        size--;
        return removedElement;
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
