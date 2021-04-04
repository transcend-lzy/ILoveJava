package com.chaoyue.java;

/**
 * @author chaoyue
 * @data2021-04-02 10:29
 */
public class ReturnExceptionTest {
    static void methodA(){
        try {
            System.out.println("进入A");
            throw  new RuntimeException("制造异常");
        } finally {
            System.out.println("a的finally");
        }
    }

    static int methodB(){
        int num;
        try {
            num = 1;
            System.out.println("go in B");
            return num;

        } finally {
            System.out.println("b finally");
        }

    }

    public static void main(String[] args) {
        try {
            ReturnExceptionTest.methodA();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        System.out.println(methodB());
    }

}
