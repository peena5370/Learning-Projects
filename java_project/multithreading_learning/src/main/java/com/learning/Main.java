package com.learning;

import com.learning.concurrent.ShareResource;
import com.learning.concurrent.SynchronizedShareResource;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");

        for (int i = 1; i <= 5; i++) {
            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
            System.out.println("i = " + i);
        }

        SynchronizedShareResource resource = new SynchronizedShareResource();

        Runnable task = () -> {
            for (int i = 0; i < 5; i++) {
                resource.increment();
                try {
                    Thread.sleep(100); // Simulate some work
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        };

        Thread t1 = new Thread(task, "Thread-1");
        Thread t2 = new Thread(task, "Thread-2");

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Final Counter: " + resource.getCounter());

        System.out.println("-------------------");
        ShareResource reentrantResource = new ShareResource();

        Runnable task2 = () -> {
            for (int i = 0; i < 5; i++) {
                reentrantResource.increment();
                try {
                    Thread.sleep(100); // Simulate some work
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        };

        Thread t3 = new Thread(task2, "Thread-3");
        Thread t4 = new Thread(task2, "Thread-4");

        t3.start();
        t4.start();

        try {
            t3.join();
            t4.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Final Counter: " + resource.getCounter());
    }
}