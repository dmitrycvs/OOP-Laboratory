package oop.practice.Task1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class QueueTest {
    @Test
    public void test() {
        Queue<Integer> queue = new ArrayQueue<>(10);
        assertTrue(queue.isEmpty());
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        assertEquals(3, queue.size());
    }
}
