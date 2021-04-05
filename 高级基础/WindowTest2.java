package com.chaoyue.java;

import javax.swing.plaf.TreeUI;
//同步代码块解决thread继承类的线程安全问题
/**
 * @author chaoyue
 * @data2021-04-05 11:28
 */
public class WindowTest2 {
    public static void main(String[] args) {
        Thread t1 = new Thread();
        Thread t2 = new Thread();
        Thread t3 = new Thread();
        t1.setName("窗口一");
        t2.setName("窗口二");
        t3.setName("窗口三");
        t1.start();
        t2.start();
        t3.start();
    }
}

class window3 extends Thread{
    private static int ticket = 1000;

    @Override
    public void run() {
        while (true){
            synchronized (window3.class){
                if (ticket > 0){
                    System.out.println(getName() + " sale tickets " + ticket);
                }else
                {
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
