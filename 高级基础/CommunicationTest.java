package com.chaoyue.java;

/**
 * @author chaoyue
 * @data2021-04-08 18:43
 */
public class CommunicationTest {
    public static void main(String[] args) {
        Number n1 = new Number();
        Thread t1 = new Thread(n1);
        Thread t2 = new Thread(n1);
        t1.setName("process1");
        t2.setName("process2");
        t1.start();
        t2.start();
    }
}
class Number implements Runnable {
    private int number = 1;
    private Object obj = new Object();

    @Override
    public void run() {
        while (true) {
            synchronized (obj) {
                obj.notify();  //比如线程一先进来，这时候没啥用，当第二次线程二进来了，就会先执行这个代码，把线程一唤醒，
                //防止两个线程都阻塞
                if (number <= 100) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName() + ":" + number);
                    number++;

                    try {
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    break;
                }
            }
        }
    }
}