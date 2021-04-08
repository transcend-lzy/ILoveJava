package com.chaoyue.java;

import org.junit.experimental.theories.Theories;

import java.util.Calendar;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author chaoyue
 * @data2021-04-08 20:19
 */
//callable 1、有返回值 2、可以抛出异常  3、支持泛型
public class CallableTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        NumThread numThread = new NumThread();
        FutureTask<Integer> futureTask = new FutureTask<Integer>(numThread);
        new Thread(futureTask).start();
        Integer sum = futureTask.get();
        System.out.println("总和为:" + sum);

    }
}

class NumThread implements Callable{
    @Override
    public Object call() throws Exception {
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            if(i%2==0){
                System.out.println(i);
                sum+=i;
            }
        }
        return sum;
    }

}