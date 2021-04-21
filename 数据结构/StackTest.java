package com.chaoyue.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/**
 * @author chaoyue
 * @data2021-04-20 21:41
 */
public class StackTest {

}
class Stack{
    private int maxsize;
    public int top = -1;
    public ArrayList<Integer> array;

    public Stack(ArrayList<Integer> array,int maxsize) {
        this.array = array;
        this.maxsize = maxsize;
    }

    @Override
    public String toString() {
        return "Stack{" +
                "array=" + array +
                '}';
    }

    public boolean isFull(){
        if (top == maxsize -1){
            System.out.println("当前栈已经满了");
            return true;
        }
        return false;
    }


    public void pop(int num){
        if (this.isFull()){
            System.out.println("该栈已经满了");
            return;
        }else{
            array.add(num);
            top++;
        }

    }
    public void push(){
        if (array.isEmpty()){
            System.out.println("该栈没有任何东西");
            return;
        }else{
            array.remove(array.get(top));
            top--;
        }

    }

    public void showStack(){
        if (array.isEmpty()){
            System.out.println("该栈没有任何东西");
            return;
        }else{
            Iterator it = array.iterator();
            while(it.hasNext()){
                System.out.println(it.next());
            }
        }
    }
}
