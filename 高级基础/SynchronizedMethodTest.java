package com.chaoyue.java;

/**
 * @author chaoyue
 * @data2021-04-05 11:38
 */
public class SynchronizedMethodTest {
    public static void main(String[] args) {
        window4 w1 = new window4();
        Thread t1 = new Thread(w1);
        Thread t2 = new Thread(w1);
        Thread t3 = new Thread(w1);
        t1.setName("w1");
        t2.setName("w2");
        t3.setName("w3");
        t1.start();
        t2.start();
        t3.start();
    }
}


class window4 implements Runnable{
    private static int ticket = 500;

    @Override
    public void run() {
        while (true){
            show();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private synchronized void show() {  //这里同步方法就相当于synchronized(this
        if (ticket > 0 ){
            System.out.println(Thread.currentThread().getName() + " sale ticket " + ticket);
            ticket--;
        }

    }
}
