package ru.strelchm.multithreading.thread;

public class RunnableExample implements Runnable {
    private final int threadNumber;

    public RunnableExample(int threadNumber) {
        this.threadNumber = threadNumber;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(100);
                System.out.format("runnable sleep %s: %s\n", threadNumber, i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new Thread(new RunnableExample(1)).start();
        new Thread(new RunnableExample(2)).start();
    }
}