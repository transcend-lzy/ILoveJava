package com.chaoyue.java;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author chaoyue
 * @data2021-04-08 20:36
 */
public class PoolsTest {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(10);
        service.execute(new NumberThread());
        service.execute(new NumberThread1());

        service.shutdown();
    }
}

class NumberThread implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            if(i % 2 == 0 ){
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}


class NumberThread1 implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            if(i%2 != 0){
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }

        }
    }
}