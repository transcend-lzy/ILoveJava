package com.chaoyue.java;

import java.util.concurrent.ForkJoinPool;

/**
 * @author chaoyue
 * @data2021-04-20 16:40
 */
public class CircleLinkedListDemo {
    public static void main(String[] args) {
        CircleLinedList circleLinedList = new CircleLinedList();
        circleLinedList.add(5);
        circleLinedList.showJosephu();
        circleLinedList.countBoy(1,3,5);
    }
}
class CircleLinedList{
    private JosephuNode first;

    public void add(int nums){
        first = new JosephuNode(1);
        JosephuNode temp = first;
        for(int i = 1; i<nums; i++){
            JosephuNode currentNode = new JosephuNode(i + 1);
            if (i == nums-1){
                temp.setNext(currentNode);
                temp = currentNode;
                temp.setNext(first);

            }else{
                temp.setNext(currentNode);
                temp = currentNode;
            }
        }

    }
    public void showJosephu(){
        JosephuNode temp = first.getNext();
        System.out.println(first);
        while (true){
            System.out.println(temp);
            if (temp.getNext() == first){
                break;
            }
            temp = temp.getNext();
        }
    }
    public void countBoy(int startNum,int countNum,int nums){
        if (startNum <1 || startNum > nums || first == null){
            if (startNum <1 || startNum > nums){
                System.out.println("输入的数据有误");
            }
            if(first == null){
                System.out.println("还没有往环形链表中加数据");
            }
            return;
        }
        for (int i = 0; i < nums; i++) {
            System.out.printf("现在是第%d个小孩将被抛出\n",i+1);
            JosephuNode temp = first;
            while (true){
                if (temp.getNext() == first){
                    break;
                }
                temp = temp.getNext();
            }
            for (int j = 0;j<startNum-1;j++){
                first = first.getNext();
                temp = temp.getNext();
            }
            for (int k = 0;k < countNum-1; k++){
                first = first.getNext();
                temp = temp.getNext();
            }
            System.out.printf("此次抛出的小孩的代号是%d\n",first.getNum());
            temp.setNext(first.getNext());
            first = first.getNext();
        }

    }
}
class JosephuNode{
    private int num;
    private JosephuNode next;

    public JosephuNode(int num) {
        this.num = num;
    }

    public JosephuNode getNext() {
        return next;
    }

    public void setNext(JosephuNode next) {
        this.next = next;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "JosephuNode{" +
                "num=" + num +
                '}';
    }
}
