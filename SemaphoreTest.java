//package ;

import java.util.concurrent.Semaphore;

public class SemaphoreTest {
    private static Semaphore semaphore = new Semaphore(1);


    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread() {
            @Override
            public void run() {
                super.run();

                System.out.println("First thread start: " + semaphore.availablePermits());

                while (true) {
                    try {

                        System.out.println("First thread sleep: " + semaphore.availablePermits());
                        sleep(20000);

                        semaphore.release();
                    } catch (InterruptedException e) {
                        System.out.println("First thread END with interrupt!");
                        return;
                    }
                }
            }
        };

        System.out.println("Semaphore acquire: " + semaphore.availablePermits());

        semaphore.acquire();   //priority = 0;

        t1.start();            //sleep & release priority to 1


        semaphore.acquire();   //wait 4 free

        System.out.println("----" + semaphore.availablePermits() + ": " + semaphore.availablePermits());
    }
}
