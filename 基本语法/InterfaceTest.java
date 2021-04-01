package com.chaoyue.java;

import javax.swing.plaf.ComponentUI;

/**
 * @author chaoyue
 * @data2021-04-01 19:51
 */
public interface InterfaceTest {
    public static void main(String[] args) {
        compuetr compuetr = new compuetr();
        compuetr.print(new Flash());
        compuetr.print(new Printer());
        InterfaceTest.test();

    }
    static void test(){
        System.out.println("i'm test");
    }
    void start();
    void stop();
    int NUM = 1;
}

class Printer implements InterfaceTest{
    @Override
    public void start() {
        System.out.println(this.NUM);
        System.out.println("printer start");
    }

    @Override
    public void stop() {
        System.out.println("printer stop");
    }
}

class Flash implements InterfaceTest{
    @Override
    public void start() {
        System.out.println("flash start");
    }

    @Override
    public void stop() {
        System.out.println("flash stop");
    }
}

class compuetr{
    void print(InterfaceTest inter){
        inter.start();
        inter.stop();
    }
}
