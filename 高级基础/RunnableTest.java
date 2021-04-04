package com.chaoyue.java;

/**
 * @author chaoyue
 * @data2021-04-04 20:15
 */
public class RunnableTest {
    public static void main(String[] args) {
        Mthread mthread = new Mthread();
        Thread thread = new Thread(mthread);
        thread.setName("thread1");
        thread.start();

        Thread thread1 = new Thread(mthread);
        thread1.setName("thread2");
        thread1.start();
    }
}

class Mthread implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if(i % 2 == 0){
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}
