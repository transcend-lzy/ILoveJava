package com.chaoyue.java;

/**
 * @author chaoyue
 * @data2021-04-01 10:22
 */
//代码块、final
public class StaticTest {
    public static void main(String ... args){
        new Leaf("abc");
        System.out.println(" ");
        new Leaf("cda");
    }
}
class Root{
    static {
        System.out.println("root static diamakuai");
    }
    {
        System.out.println("root feijingtai");
    }

    public Root() {
    }
}

class Mid extends Root{
    static {
        System.out.println("Mid jingtai");
    }
    {
        System.out.println("mid feijingtai");
    }

    public Mid() {
    }
    public Mid(String msg){
        this();
        System.out.println("dai can gouzaoqi:"+msg);
    }
}

class Leaf extends Mid{
    {
        System.out.println("leaf feijingtai");
    }
    static {
        System.out.println("leaf jingtai");
    }
    public Leaf(String msg){
        super(msg);
        System.out.println("leaf gouzaoqi");
    }

}


