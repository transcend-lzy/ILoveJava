package com.chaoyue.java;

import java.util.function.DoubleToIntFunction;

/**
 * @author chaoyue
 * @data2021-04-12 8:33
 */
public class LinklistTest {
    public static void main(String[] args) {
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");

        SingleLinkedList singleLinkedList = new SingleLinkedList();
//
//        singleLinkedList.addNode(hero1);
//        singleLinkedList.addNode(hero4);
//        singleLinkedList.addNode(hero2);
//        singleLinkedList.addNode(hero3);

//加入按照编号的顺序
        singleLinkedList.addByOrder(hero1);
        singleLinkedList.addByOrder(hero4);
        singleLinkedList.addByOrder(hero2);
        singleLinkedList.addByOrder(hero3);

//
        singleLinkedList.list();
        HeroNode newHeroNode = new HeroNode(2, "小卢", "玉麒麟~~");
        singleLinkedList.updateNode(newHeroNode);
        System.out.println("修改后的链表情况~~");
        singleLinkedList.list();
////删除一个节点
        singleLinkedList.delNode(1);
        singleLinkedList.delNode(4);

        System.out.println("删除后的链表情况~~");
        singleLinkedList.list();
    }
}

class HeroNode{
    private int num;
    private String name;
    private String nickName;
    HeroNode next;

    public HeroNode(int num, String name, String nickName) {
        this.num = num;
        this.name = name;
        this.nickName = nickName;
    }

    public HeroNode(int num, String name, String nickName, HeroNode next) {
        this.num = num;
        this.name = name;
        this.nickName = nickName;
        this.next = next;
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

    public HeroNode getNext() {
        return next;
    }

    public void setNext(HeroNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "num=" + num +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}


class SingleLinkedList{
    HeroNode headNode = new HeroNode(0, "", "", null);
    public SingleLinkedList(){


    }
    public void addNode(HeroNode heroNode){
        HeroNode node = headNode;
        while (node.next != null){
            node = node.next;
        }
        node.next = heroNode;
        node.next.setNext(null);
    }

    public void addByOrder(HeroNode heroNode){
        HeroNode node = headNode;
        while (node.next != null){
            if (node.next.getNum() == heroNode.getNum()){
                System.out.println("编号已存在，不能添加");
                return;
            }
            if (node.next.getNum() > heroNode.getNum()){
                heroNode.next = node.next;
                node.next = heroNode;
                heroNode.next.setNext(null);
                return;
            }
            node = node.next;
        }
        node.next = heroNode;
        node.next.setNext(null);
    }

    public  void updateNode(HeroNode heroNode){
        HeroNode node = headNode;
        boolean flag = true;
        while (node.next != null){
           if(node.getNum() == heroNode.getNum()){
               node.setName(heroNode.getName());
               node.setNickName(heroNode.getNickName());
               return;
           }
           node = node.next;
        }
        System.out.println("没有找到应该转换的那个节点");
    }
    public void delNode(int num){
        HeroNode node = headNode;
        while (node.next != null){
            if (node.next.getNum() == num){
                node.next = node.next.next;
                return;
            }
            node = node.next;
        }
        System.out.println("没有找到应该删除的那个节点");
    }
    public void list(){//遍历
        HeroNode node = headNode.next;
        if (node == null){
            System.out.println("链表为空");
        }
        while (node != null){
            System.out.println(node);
            node = node.next;
        }
    }

}