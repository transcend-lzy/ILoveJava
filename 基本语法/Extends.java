package com.chaoyue.java;

import org.junit.Test;

/**
 * @author chaoyue
 * @data2021-03-30 21:36
 */
public class Extends {
    public static void main(String[] args) {
        person person = new person();
        System.out.println(person.getName());
    }
    private String name = "tom";
    private int age = 12;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Extends(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Extends() {
    }
}
class person extends Extends{
    private String name = "abc";
    @Override
    public int getAge() {
        return super.getAge();
    }
}