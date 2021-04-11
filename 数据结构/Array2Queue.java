package com.chaoyue.java;

import javax.print.attribute.standard.ReferenceUriSchemesSupported;
import java.util.Scanner;

/**
 * @author chaoyue
 * @data2021-04-11 20:20
 */
public class Array2Queue {
    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(4);
        char key = ' '; // 接收用户输入
        Scanner scanner = new Scanner(System.in);//
        boolean loop = true;
// 输出一个菜单
        while (loop) {
            System.out.println("s(show): 显示队列");
            System.out.println("e(exit): 退出程序");
            System.out.println("a(add): 添加数据到队列");
            System.out.println("g(get): 从队列取出数据");
            System.out.println("h(head): 查看队列头的数据");
            key = scanner.next().charAt(0);// 接收一个字符
            switch (key) {
                case 's':
                    queue.showQueue();
                    break;
                case 'a':
                    System.out.println("输出一个数");
                    int value = scanner.nextInt();
                    queue.addQueue(value);
                    break;
                case 'g': // 取出数据
                    try {
                        int res = queue.getQueue();
                        System.out.printf("取出的数据是%d\n", res);
                    } catch (Exception e) {
// TODO: handle exception
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h': // 查看队列头的数据
                    try {
                        int res = queue.headQueue();
                        System.out.printf("队列头的数据是%d\n", res);
                    } catch (Exception e) {
// TODO: handle exception
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e': // 退出
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序退出~~");
    }
}

class ArrayQueue{
    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;
    public ArrayQueue(int arrMaxSize){
        maxSize = arrMaxSize;
        front = 0;
        rear = 0;
        arr = new int[arrMaxSize];
    }
    public boolean isFull(){
         return (rear+1)%maxSize == front;
    }
    public boolean isEmpty(){
        return rear == front;
    }

    public void addQueue(int n ){
        if(isFull()){
            throw  new RuntimeException("Queue is full,can't add");
        }
        else{
            arr[rear] = n;
        }
        rear = (rear+1)%maxSize;
    }
    public int getQueue(){
        if(isEmpty()){
            throw new RuntimeException("Queue is empty,can't get!");
        }
        int val = arr[front];
        front = (front+1)%maxSize;
        return val;

    }
    public void showQueue(){
        if(isEmpty()){
            System.out.println("Queue is empty");
            return;
        }else{
            while (rear != front ) {
                System.out.println(arr[front]);
                front = (front+1)%maxSize;
            }
        }
    }

    public int size(){
        return (rear + maxSize - front)%maxSize;
    }
    public int headQueue(){
        if(isEmpty()){
            throw new RuntimeException("Queue is empty!");
        }else{
            return arr[front];
        }
    }
}
