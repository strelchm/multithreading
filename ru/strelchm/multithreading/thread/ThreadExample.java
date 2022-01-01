package ru.strelchm.multithreading.thread;

public class ThreadExample extends Thread {
    private final int threadNumber;

    public ThreadExample(int threadNumber) {
        this.threadNumber = threadNumber;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(100);
                System.out.format("thread sleep %s: %s\n", threadNumber, i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new ThreadExample(1).start();
        new ThreadExample(2).start();
    }
}
