package com.chaoyue.java;

import org.junit.Test;

import java.util.ArrayList;

/**
 * @author chaoyue
 * @data2021-03-28 19:26
 */
/*
包名：xxxyyyzzz
类名、接口名：XxxYyyZzz
变量名、方法名：xxxYyyZzz
常量名：XXX_YYY_ZZZ
 */
public class BasicKnowledgePoints {
    @Test
    public void test1() {
        long num1 = 123124;
        char a2 = 98;
//        System.out.println(a);
        short s = 5;
        int a1 = 10;
        int b1 = a1++;
        boolean b3 = false;
        b3 = true;
        int num3 = 10;
        if (b3 || (num3++ > 0)) {
            System.out.println("我现在在北京");
        } else {
            System.out.println("我现在在南京");
        }
        System.out.println("num3 =" + num3);
        int [] array1 = {1, 2, 3, 4, 5};
        for (int a:array1) {
            switch (a) {
                case 1:
                    System.out.println(a);
                case 2:
                    System.out.println(a);
                case 3:
                    System.out.println(a);
                case 4:
                    System.out.println(a);
            }
        }

    }

}
