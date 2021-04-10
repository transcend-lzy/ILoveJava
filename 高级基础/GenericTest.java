package com.chaoyue.java;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chaoyue
 * @data2021-04-10 10:25
 */
//自定义泛型类
public class GenericTest<T> {
    String orderName;
    int orderId;

    T orderT;

    public GenericTest(){
        T[] arr = (T[]) new Object[10];
    }

    public GenericTest(String orderName, int orderId, T orderT) {
        this.orderName = orderName;
        this.orderId = orderId;
        this.orderT = orderT;
    }

    public T getOrderT() {
        return orderT;
    }

    public void setOrderT(T orderT) {
        this.orderT = orderT;
    }

    @Override
    public String toString() {
        return "GenericTest{" +
                "orderName='" + orderName + '\'' +
                ", orderId=" + orderId +
                ", orderT=" + orderT +
                '}';
    }
    public static <E> List<E> copyFromArrayToList(E[] arr){
        ArrayList<E> list = new ArrayList<>();
        for (E e : arr){
            list.add(e);
        }
        return list;
    }

}

