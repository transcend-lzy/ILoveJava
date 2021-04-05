package com.chaoyue.java;

import javax.security.auth.callback.TextInputCallback;
//同步代码块解决runnable的线程安全问题
/**
 * @author chaoyue
 * @data2021-04-05 11:09
 */
public class SynchronizedTest {
    public static void main(String[] args) {
        window1 w = new window1();
        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        Thread t3 = new Thread(w);
        t1.setName("w1");
        t1.setPriority(Thread.MIN_PRIORITY);
        t2.setName("w2");
        t2.setPriority(Thread.MAX_PRIORITY);
        t3.setName("w3");

        t1.start();
        t2.start();
        t3.start();
    }
}

class window1 implements Runnable {
    private int ticket = 1000;

    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                if (ticket > 0) {

                    System.out.println(Thread.currentThread().getName() + " sale tickets" + ticket);
                    ticket--;
                } else {
                    break;
                }
            }
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}