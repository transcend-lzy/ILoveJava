package com.chaoyue.java;

import org.junit.Test;

import java.util.Scanner;
import java.util.spi.LocaleNameProvider;

/**
 * @author chaoyue
 * @data2021-04-02 9:46
 */
public class ExceptionTest {
    public static void main(String[] args) {
        ExceptionTest exceptionTest = new ExceptionTest();
    }
    public void excetest(){
        Scanner scanner = new Scanner(System.in);
        int score = scanner.nextInt();
        System.out.println(score);

        scanner.close();
    }
    @Test
    public void test1(){
        try {
            int a = 10;
            int b = 0;
            System.out.println(a / b);
        }
        catch (ArithmeticException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
        finally{
            System.out.println("i'm handsome");
        }
    }
    @Test
    public void test2() throws Exception {
        int id = -1;
        if (id > 0){
            System.out.println(id);
        }
        else{
//            throw new MyException();
//            throw new MyException("不能输入负数");
//            throw new RuntimeException("你这数据不行");
            throw new Exception("输入数据非法");

        }
    }
}



class MyException extends Exception{
    static final long serialVersionUID = -7034897193234539L;

    public MyException() {
    }

    public MyException(String message) {
        super(message);
    }
}