package ru.strelchm.multithreading.syncronized;

import static ru.strelchm.multithreading.syncronized.SynchronizationTest.LOOP_COUNTER;
import static ru.strelchm.multithreading.syncronized.SynchronizationTest.SLEEP_TIMEOUT;

public class StaticSyncronization {
    public static void main(String[] args) {
        System.out.println("Start");
        new Thread(StaticSyncronization::method).start();
        new Thread(StaticSyncronization::method).start();
    }

    public synchronized static void method() { // class syncronization
        for (int i = 0; i < LOOP_COUNTER; i++) {
            System.out.println(i);
            try {
                Thread.sleep(SLEEP_TIMEOUT);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
