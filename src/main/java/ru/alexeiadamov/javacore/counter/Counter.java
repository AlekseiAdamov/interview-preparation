package ru.alexeiadamov.javacore.counter;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Counter {
    private final Lock lock = new ReentrantLock();
    private long counter = 0L;

    public void increase() {
        lock.lock();
        try {
            counter++;
        } finally {
            lock.unlock();
        }
    }

    public long get() {
        return counter;
    }
}
