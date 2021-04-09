package com.chaoyue.java;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @author chaoyue
 * @data2021-04-09 19:41
 */

//自然排序，Comparable接口
    //定制排序，Comparator接口
public class ComparableTest {
    public static void main(String[] args) {

    }
    @Test
    public void test3(){
        String[] arr = new String[]{"aa","bb","cc","dd","ee"};
        Arrays.sort(arr, new Comparator<String>() {  //工具类Arrays
            @Override
            public int compare(String o1, String o2) {
                if(o1 instanceof String && o2 instanceof String){
                    String s1 = (String) o1;
                    String s2 = (String) o2;
                    return -s1.compareTo(s2);
                }else{
                    throw new RuntimeException("input not same");
                }
            }
        });
    }
}

class Goods implements Comparable{
    private String name;
    private double price;

    @Override
    public int compareTo(Object o) {
        if (o instanceof Goods){
            Goods good = (Goods)o;
            if(this.price>good.price){
                return 1;
            }
            else if(this.price>good.price){
                return -1;
            }else{
                return this.name.compareTo(good.name);
            }
        }else{
            throw new RuntimeException("传入数据类型不一致");
        }
    }
}

