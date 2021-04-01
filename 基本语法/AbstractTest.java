package com.chaoyue.java;

import javax.swing.*;
import java.security.PublicKey;
import java.sql.Struct;

/**
 * @author chaoyue
 * @data2021-04-01 10:38
 */
public class AbstractTest {
    public static void main(String[] args) {
        Student student = new Student("tom",13);
        student.printabc();

    }
}
abstract class  Creature{
    public abstract void breath();
    public void printabc(){
        System.out.println("abc");
    }

}

abstract class Person2 extends Creature{
    String name;
    int age;

    public Person2(){

    }

    public Person2(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public abstract void eat();
}

class Student extends Person2{
    public Student(String name, int age){
        super(name,age);
    }

    @Override
    public void eat() {
        System.out.println("student eat");
    }

    @Override
    public void breath() {
        System.out.println("student breath");
    }
}