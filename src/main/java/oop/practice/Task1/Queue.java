package oop.practice.Task1;

public interface Queue<T> {
    void enqueue(T element);
    T dequeue();
    boolean isEmpty();
    int size();
}
