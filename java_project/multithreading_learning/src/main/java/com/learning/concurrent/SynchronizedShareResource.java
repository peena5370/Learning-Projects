package com.learning.concurrent;

public class SynchronizedShareResource {
    private int counter = 0;

    public synchronized void increment() {
        counter++;
        System.out.println(Thread.currentThread().getName() + ": " + counter);
    }

    public synchronized int getCounter() {
        return counter;
    }
}
