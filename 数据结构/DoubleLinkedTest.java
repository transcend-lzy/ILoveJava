package com.chaoyue.java;

import javax.print.attribute.standard.ReferenceUriSchemesSupported;
import javax.swing.plaf.TreeUI;

/**
 * @author chaoyue
 * @data2021-04-20 9:09
 */
public class DoubleLinkedTest {

}
class DoubleLinkedList{
    public HeroNode1 head = new HeroNode1(0,"","");

    public HeroNode1 getHead() {
        return head;
    }

    public void list(){  //遍历
        if (head.next == null){
            System.out.println("链表为空");
        }else{
            HeroNode1 temp = head;
            while (temp.next != null){
                System.out.println(temp.next);
                temp= temp.next;
            }
        }
    }
    public void add(HeroNode1 heroNode){//将形参节点添加到最后
        HeroNode1 temp = head.next;
        while (true){
            if (temp == null){

                break;
            }
            temp = temp.next;
        }
        temp.next = heroNode;
        heroNode.pre = temp;
    }
    public void update(HeroNode1 heroNode1){
        HeroNode1 temp = head.next;
        boolean flag = true;
        if (temp == null){
            System.out.println("链表为空");
            return;
        }else
            {
        while (true){
            if (temp == null){
                if (temp.num == heroNode1.num){
                    flag = false;
                    break;
                }
            }
            temp = temp.next;
        }

            }
        if (flag == true){
            heroNode1.next = temp.next;
            heroNode1.pre = temp.pre;
        }else{
            System.out.println("没有找到对应序号的节点");
        }
    }

    public void del(int num){
        HeroNode1 temp = head.next;
        boolean flag = false;
        if (temp == null){
            System.out.println("链表为空，无法删除");
            return;
        }else{
            while (true) {
                if (temp.next == null) {
                    if (temp.num == num) {

                        flag = true;
                    }
                    break;
                }
                temp = temp.next;
            }
        }
        if (flag == false){
            System.out.println("没找到对应的要删除内容");
        }else{
            temp.next.pre = temp.pre;
            temp.pre.next = temp.next;
        }
    }
}

class HeroNode1{
    public int num = 0;
    public String name;
    public String nickName;
    public HeroNode1 next;
    public HeroNode1 pre;

    public HeroNode1(int num, String name, String nickName) {
        this.num = num;
        this.name = name;
        this.nickName = nickName;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public HeroNode1 getNext() {
        return next;
    }

    public void setNext(HeroNode1 next) {
        this.next = next;
    }

    public HeroNode1 getPre() {
        return pre;
    }

    public void setPre(HeroNode1 pre) {
        this.pre = pre;
    }

    @Override
    public String toString() {
        return "HeroNode1{" +
                "num=" + num +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}