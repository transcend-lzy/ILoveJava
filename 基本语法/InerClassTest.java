package com.chaoyue.java;

/**
 * @author chaoyue
 * @data2021-04-02 9:36
 */
//内部类
public class InerClassTest {
    public static void main(String[] args) {
        Person.Dog dog = new Person.Dog();
        Person p = new Person();
        Person.Bird bird = p.new Bird();
    }
}

class Person{
    String name = "xiaoming";
    static String dogName = "tom";
    public static void dogEat(){
        System.out.println("dog eat");
    }
    public void eat(){
        System.out.println("eat()");
    }
    class Bird{
        String name = "dujuan";
        public void display(String name){
            System.out.println(name);
            System.out.println(this.name);
            System.out.println(Person.this.name);
            Person.this.eat();
        }
    }
    static class Dog{
        String name = "dujuan";
        public void display(String name){
            System.out.println(name);
            System.out.println(this.name);
            System.out.println(Person.dogName);
            Person.dogEat();
        }
    }
}