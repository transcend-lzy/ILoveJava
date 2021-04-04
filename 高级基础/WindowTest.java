package com.chaoyue.java;

/**
 * @author chaoyue
 * @data2021-04-04 22:12
 */
public class WindowTest {
    public static void main(String[] args) {
        Window window1 = new Window();
        Window window2 = new Window();
        Window window3 = new Window();

        window1.setName("window1");
        window2.setName("window2");
        window3.setName("window3");

        window1.start();
        window2.start();
        window3.start();
    }
}

class Window extends Thread {
    private static int ticket = 90;

    @Override
    public void run() {
        while (true) {
            if (ticket > 0) {

                System.out.println(getName() + ":sale tickets ,ticket num =" + ticket);
                ticket--;

            } else {
                break;
            }
        }
    }
}
