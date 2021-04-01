package com.chaoyue.java;

import java.lang.management.RuntimeMXBean;

/**
 * @author chaoyue
 * @data2021-04-01 19:13
 */
public class TemplateMethodTest {
    public static void main(String[] args) {
        DrawMoney drawMoney = new DrawMoney();
        drawMoney.process();

        ManageMoney manageMoney = new ManageMoney();
        manageMoney.process();
    }
}
abstract class BankTemplateMethod{
    public void takeNumber(){
        System.out.println("取号排队");
    }
    public abstract void transact();
    public void evaluate(){
        System.out.println("反馈评分");
    }

    public final void process(){
        this.takeNumber();

        this.transact();

        this.evaluate();
    }

}

class DrawMoney extends BankTemplateMethod{
    @Override
    public void transact() {
        System.out.println("drawMoney");
    }

}

class ManageMoney extends BankTemplateMethod{
    @Override
    public void transact() {
        System.out.println("ManageMoney");
    }
}