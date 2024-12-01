package oop.practice.Queue;

public interface Queue<T> {
    void enqueue(T element);
    T dequeue();
    boolean isEmpty();
    int size();
}
