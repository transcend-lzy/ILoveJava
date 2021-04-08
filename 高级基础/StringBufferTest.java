package com.chaoyue.java;

import java.sql.SQLOutput;

/**
 * @author chaoyue
 * @data2021-04-08 20:51
 */
public class StringBufferTest {
    public static void main(String[] args) {
        StringBuffer stringBuffer = new StringBuffer();
        System.out.println(stringBuffer.length());
        stringBuffer.append('a');
        System.out.println(stringBuffer.length());
        StringBuffer abc = new StringBuffer("abc");
        System.out.println(abc.length());
    }
}
