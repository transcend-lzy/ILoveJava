package com.chaoyue.java;

import org.junit.Test;

import java.util.*;

/**
 * @author chaoyue
 * @data2021-04-09 21:06
 */
public class CollectionsTest {
    @Test
    public void test(){
        ArrayList<Object> objects = new ArrayList<>();
        objects.add(123);
        objects.add(2356);
        objects.add("sdg");
        objects.add(new Person("sdgh",23));

        List dest = Arrays.asList(new Object[objects.size()]);
        System.out.println(dest.size());
        Collections.copy(dest,objects);

        System.out.println(dest);
    }
}
