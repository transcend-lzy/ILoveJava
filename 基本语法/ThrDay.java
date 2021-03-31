package com.chaoyue.java;

import org.junit.Test;

import javax.naming.Name;
import javax.print.DocFlavor;
import java.sql.SQLOutput;

/**
 * @author chaoyue
 * @data2021-03-31 19:04
 */

//包装类、类的继承、this和super、static
public class ThrDay {
    private double aNum;
    @Test
    public void test(){
        Integer t = 1; //自动装箱 5.0新特性
        int num1 = t; //自动拆箱  5.0新特性
        String str = "123";
        int num2 = Integer.parseInt(str);
        String str1 = String.valueOf(32323232435L);
        System.out.println(str1);
    }
    @Test
    public void test2(){
        Account acct1 = new Account();
        Account acc2 = new Account("000",2000);
        Account.setInterestRate(0.012);
        Account.setMinMoney(100);
        System.out.println(acc2);
        System.out.println(acct1);
        System.out.println(acc2.getInterestRate());
        System.out.println(acct1.getMinMoney());
    }
    public ThrDay() {
    }


    public double findArea(){
        return 1.0;
    }
}
class Cylinder extends ThrDay{
    private String name ;
    private int age;

    public Cylinder() {
    }

    public Cylinder(String name) {
        this.name = name;
    }
    public Cylinder(String name,int age) {
        this(name);
        this.age = age;

    }


    public double findArea(){

        System.out.println(super.findArea());
        return 2.0;
    }

}

class Account {
    private  int id ;
    private String pwd = "000000";
    private double balance;

    private static double interestRate;
    private static double minMoney = 1.0;
    private static int init = 1001;
    public Account(){
        id = init++;
    }
    public Account(String pwd,double balance){
        id = init++;
        this.pwd = pwd;
        this.balance =balance;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public static double getInterestRate() {
        return interestRate;
    }

    public static void setInterestRate(double interestRate) {
        Account.interestRate = interestRate;
    }

    public static double getMinMoney() {
        return minMoney;
    }

    public static void setMinMoney(double minMoney) {
        Account.minMoney = minMoney;
    }

    public static int getInit() {
        return init;
    }

    public static void setInit(int init) {
        Account.init = init;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", pwd='" + pwd + '\'' +
                ", balance=" + balance +
                '}';
    }
}
