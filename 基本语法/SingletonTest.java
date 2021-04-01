package com.chaoyue.java;

/**
 * @author chaoyue
 * @data2021-04-01 10:08
 */
//单例模式，采取一定的方法保证整个软件系统中，对某个类只存在一个对象实例
public class SingletonTest {

}
//饿汉式
class Bank{
    private Bank(){

    }
    private static Bank instance = new Bank();

    public static Bank getInstance(){
        return instance;
    }
}

//饿汉式 使用静态代码块
class Order{
    private Order(){

    }
    private static Order instance = null;

    static {
        instance = new Order();
    }
    public static Order getInstance(){
        return instance;
    }

}

//懒汉式 什么时候用什么时候造
class Order1{
    private Order1(){

    }
    private static Order1 instance = null;

    public static Order1 getInstance(){
        if (instance == null){
            instance = new Order1();
        }
        return instance;
    }
}
