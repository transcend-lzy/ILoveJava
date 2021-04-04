package com.chaoyue.java;

import javax.print.attribute.standard.RequestingUserName;
import javax.xml.stream.events.StartDocument;

/**
 * @author chaoyue
 * @data2021-04-04 22:18
 */
public class WindowTestRun {
    public static void main(String[] args) {
        WindowSafe w = new WindowSafe();
        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        Thread t3 = new Thread(w);
        t1.setName("run1");
        t2.setName("run2");
        t3.setName("run3");
        t1.start();
        t2.start();
        t3.start();
    }
}

class WindowSafe implements Runnable {
    private static int tickets = 100;

    @Override
    public void run() {
        while (true) {
            if (tickets > 0) {

                System.out.println(Thread.currentThread().getName() + ":sale tickets ,ticket num =" + tickets);
                tickets--;

            } else {
                break;
            }
        }
    }
}
