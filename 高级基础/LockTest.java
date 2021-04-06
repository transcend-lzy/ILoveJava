package com.chaoyue.java;

/**
 * @author chaoyue
 * @data2021-04-06 14:56
 */

//上下两个线程的锁是一样的，但是锁的先后顺序不一样，有可能一个线程先进入了是s1，另一个线程
    //先进入了s2，然后进入s1的线程等待进入s2的线程出来，但是s2的线程要想出来要进入s1，即第一个线程
    //要从s1出来，所以这样就僵持在这里了，这就是死锁。

public class LockTest {
    public static void main(String[] args) {
        StringBuffer s1 = new StringBuffer();
        StringBuffer s2 = new StringBuffer();
        new Thread(){
            @Override
            public void run() {
                synchronized (s1){
                    s1.append("a");
                    s2.append("1");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (s2){
                        s1.append("b");
                        s2.append("2");

                        System.out.println(s1);
                        System.out.println(s2);
                    }
                }
            }
        }.start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (s2){
                    s1.append("c");
                    s2.append("3");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (s1){
                        s1.append("d");
                        s2.append("4");
                        System.out.println(s1);
                        System.out.println(s2);
                    }
                }
            }
        }).start();
    }


}
