package com.learning.concurrent;

import java.util.concurrent.locks.ReentrantLock;

public class ShareResource {
    private int counter = 0;
    private final ReentrantLock lock = new ReentrantLock();

    public void increment() {
        lock.lock(); // Acquire the lock
        try {
            counter++;
            System.out.println(Thread.currentThread().getName() + ": " + counter);
        } finally {
            lock.unlock(); // Release the lock in a finally block to ensure it's always released
        }
    }

    public int getCounter() {
        lock.lock();
        try {
            return counter;
        } finally {
            lock.unlock();
        }
    }
}
