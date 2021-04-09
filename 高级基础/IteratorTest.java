package com.chaoyue.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author chaoyue
 * @data2021-04-09 20:53
 */
public class IteratorTest {
    @Test
    public void  test(){
        ArrayList<Object> objects = new ArrayList<>();
        objects.add(1213);
        objects.add("Sdas");
        objects.add(523);
        for(Object obj : objects){
            System.out.println(obj);
        }
        Iterator<Object> iterator = objects.iterator();
        while (iterator.hasNext()){
            Object obj = iterator.next();
            if ("TOM".equals(obj)){
                iterator.remove();
            }
            System.out.println(iterator.next());
        }
    }
}
