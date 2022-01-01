package ru.strelchm.multithreading.syncronized;

public class SynchronizationTest {
    public static final int LOOP_COUNTER = 100;
    public static final int SLEEP_TIMEOUT = 100;

    public static void main(String[] args) {
        SynchronizationTest e1 = new SynchronizationTest();
        System.out.println("Start");
        new Thread(e1::method1).start(); // syncronized in method => Monitor = this method Object
        new Thread(e1::method2).start();
    }
    public synchronized void method1() {
        System.out.println("Method1..START");
        for (int i = 0; i < LOOP_COUNTER; i++) {
            System.out.println(i);
            try {
                Thread.sleep(SLEEP_TIMEOUT);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Method1..STOP");
    }
    public synchronized void method2() {
        System.out.println("Method2..START");
        for (int i = 0; i < LOOP_COUNTER; i++) {
            System.out.println(i);
            try {
                Thread.sleep(SLEEP_TIMEOUT);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Method2..STOP");
    }
}
