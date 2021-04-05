package com.chaoyue.java;

import java.text.BreakIterator;

/**
 * @author chaoyue
 * @data2021-04-05 11:48
 */
public class SynchronizedMethodTest2 {
    public static void main(String[] args) {
        Window5 t1 = new Window5();
        Window5 t2 = new Window5();
        Window5 t3 = new Window5();

        t1.setName("w1");
        t2.setName("w2");
        t3.setName("w3");

        t1.start();
        t2.start();
        t3.start();
    }
}


class Window5 extends Thread{
    private static int ticket = 1000;

    @Override
    public void run() {
        while (true) {
            show();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    private static synchronized void show(){
        if (ticket > 0){
            System.out.println(Thread.currentThread().getName() + " sale ticket " + ticket);
            ticket--;
        }
    }

}
