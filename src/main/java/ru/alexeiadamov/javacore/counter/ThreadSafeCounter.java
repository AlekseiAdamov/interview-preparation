package ru.alexeiadamov.javacore.counter;

public class ThreadSafeCounter {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        for (int i = 0; i < 1000; i++) {
            CounterThread ct = new CounterThread(counter);
            new Thread(ct).start();
        }
        Thread.sleep(1000);

        System.out.println("Counter:" + counter.get());
    }
}
