package ru.strelchm.multithreading.concurrent;

import java.util.concurrent.CyclicBarrier;

/**
 * CyclicBarrier выполняет синхронизацию заданного количества потоков в одной точке. Как только
 * заданное количество потоков заблокировалось (вызовами метода await()), с них одновременно
 * снимается блокировка.
 */
public class CyclicBarrierSimpleTest {
    public static void main(String[] args) {
        CyclicBarrier cb = new CyclicBarrier(3);
        for (int i = 0; i < 3; i++) {
            final int w = i;
            new Thread(() -> {
                try {
                    System.out.println("Поток " + w + " готовится");
                    Thread.sleep(100 + (int) (30000 * Math.random()));
                    System.out.println("Поток " + w + " готов");
                    cb.await(); // Основной поток создает 6 потоков и ждет, пока каждый из них не закончит приготовление к работе.
                    System.out.println("Поток " + w + " запустился");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
        }
        System.out.println("Main thread finished!");
    }
}