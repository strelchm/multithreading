package ru.strelchm.multithreading.concurrent.semaphore;//package ;

import java.util.concurrent.Semaphore;

public class SemaphoreTest {
    private static final Semaphore SEMAPHORE = new Semaphore(1);

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread() {
            @Override
            public void run() {
                super.run();

                System.out.println("First thread start: " + SEMAPHORE.availablePermits());

                while (true) {
                    try {
                        System.out.println("First thread sleep: " + SEMAPHORE.availablePermits());
                        sleep(20000);

                        SEMAPHORE.release();
                    } catch (InterruptedException e) {
                        System.out.println("First thread END with interrupt!");
                        return;
                    }
                }
            }
        };

        System.out.println("Semaphore acquire: " + SEMAPHORE.availablePermits());

        SEMAPHORE.acquire();   //priority = 0;

        t1.start();            //sleep & release priority to 1


        SEMAPHORE.acquire();   //wait 4 free

        System.out.println("----" + SEMAPHORE.availablePermits() + ": " + SEMAPHORE.availablePermits());
    }
}
