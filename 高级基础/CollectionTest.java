package com.chaoyue.java;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/**
 * @author chaoyue
 * @data2021-04-09 20:19
 */
//Collection接口和foreach循环

public class CollectionTest {
    @Test
    public void test1(){
        Collection coll = new ArrayList();
        Collection<Object> integers = new ArrayList<>();
        integers.add("A");
        integers.add(213);
        integers.add(new Date());

        System.out.println(integers.size());

        ArrayList<String> strings = new ArrayList<>();

        strings.add("a");
        integers.addAll(strings);

        integers.clear();
        System.out.println(integers.isEmpty());

        coll.add(new Person("chaoyue",12));

        coll.add(123);
        coll.add(43);

        for(Object obj : coll){
            System.out.println(obj);
        }

    }
}
