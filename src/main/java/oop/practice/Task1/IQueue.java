package oop.practice.Task1;

public interface IQueue<T> {
    public void enqueue(T element);
    public T dequeue();
    public boolean isEmpty();
    public int size();
}