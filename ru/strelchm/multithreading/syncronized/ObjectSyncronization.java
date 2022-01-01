package ru.strelchm.multithreading.syncronized;

import static ru.strelchm.multithreading.syncronized.SynchronizationTest.LOOP_COUNTER;
import static ru.strelchm.multithreading.syncronized.SynchronizationTest.SLEEP_TIMEOUT;

public class ObjectSyncronization {
    private Object lock1 = new Object();

    public static void main(String[] args) {
        ObjectSyncronization e2 = new ObjectSyncronization();
        System.out.println("Start");
        new Thread(e2::method1).start();
        new Thread(e2::method1).start();
    }

    public void method1() {
        System.out.println("Block-1 begin");
        for (int i = 0; i < LOOP_COUNTER; i++) {
            System.out.println(i);
            try {
                Thread.sleep(SLEEP_TIMEOUT);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Block-1 end");
        synchronized (lock1) {
            System.out.println("Synch block begin");
            for (int i = 0; i < LOOP_COUNTER; i++) {
                System.out.println(i);
                try {
                    Thread.sleep(SLEEP_TIMEOUT);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Synch block end");
        }
        System.out.println("M2");
    }
}
