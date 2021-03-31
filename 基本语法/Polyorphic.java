package com.chaoyue.java;

import javax.print.DocFlavor;

/**
 * @author chaoyue
 * @data2021-03-31 19:26
 */
public class Polyorphic {
    public static void main(String[] args) {
        Person man = new Man();
        if (man instanceof Man) {
            Man man1 = (Man) man; //向下转型  向上转型就是多态
            man1.test();
        }

    }
}

class Person{
    String name;
    int age;

    int id = 1001;

    public void eat(){
        System.out.println("人吃饭");
    }
    public void walk(){
        System.out.println("person walk");
    }
}

class Man extends Person{
    @Override
    public void eat(){
        System.out.println("man eat");
    }

    @Override
    public void walk() {
        System.out.println("man walk");
    }

    public void test(){
        System.out.println("i'm test");
    }
}

class Woman extends Person{
    @Override
    public void eat() {
        System.out.println("woman eat");
    }

    @Override
    public void walk() {
        System.out.println("woman walk");
    }
}