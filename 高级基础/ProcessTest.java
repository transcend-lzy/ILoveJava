package com.chaoyue.java;

import jdk.jfr.StackTrace;
import org.junit.Test;

import javax.imageio.metadata.IIOMetadataFormatImpl;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author chaoyue
 * @data2021-04-04 19:15
 */
public class ProcessTest extends Thread {
    public static void main(String[] args) {
        HelloThread helloThread = new HelloThread();
        helloThread.setPriority(Thread.MIN_PRIORITY);
        helloThread.start();
        Thread.currentThread().setName("主线程");
        Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
        for (int i = 0; i < 100; i++) {
            if(i% 2 == 0){
                System.out.println(Thread.currentThread().getName()+":"+Thread.currentThread().getPriority()+":"+i);
            }

        }
    }

}

class HelloThread extends Thread{
    @Override
    public void run() {
        Thread.currentThread().setName("分线程");
        for (int i = 0; i < 100; i++) {
            System.out.println(getName()+":"+Thread.currentThread().getPriority()+":"+i);
        }
    }
}