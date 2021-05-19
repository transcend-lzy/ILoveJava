//散列表（Hash table，也叫哈希表），是根据关键码值(Key value)而直接进行访问的数据结构。也就是说，它通
//过把关键码值映射到表中一个位置来访问记录，以加快查找的速度。这个映射函数叫做散列函数，存放记录的数组
//叫做散列表。
package com.chaoyue.java;

import java.util.Scanner;

/**
 * @author chaoyue
 * @data2021-05-18 18:42
 */
public class HashTable {
    public static void main(String[] args) {
        HashTab hashTab = new HashTab(7);

        String key = " ";
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("add:添加雇员");
            System.out.println("list:显示雇员");
            System.out.println("exit:退出系统");
            key = scanner.next();
            switch (key){
                case("add"):
                    System.out.println("输入id");
                    int id = scanner.nextInt();
                    System.out.println("输入名字");
                    String name = scanner.next();
                    Emp emp = new Emp(id,name);
                    hashTab.add(emp);
                    break;
                case ("list"):
                    hashTab.list();
                    break;
                case("exit"):
                    scanner.close();
                    System.exit(0);
                    default:
                    break;
            }
        }
    }
}

class HashTab{
    private EmpLinkedList[] empLinkedLists;
    int size;
    public HashTab(int size){
        //初始化链表
        this.size = size;
        empLinkedLists = new EmpLinkedList[size];
        //不要忘了分别初始化每一条链表
        for (int i = 0; i < size; i++) {
            empLinkedLists[i] = new EmpLinkedList();
        }
    }
    public void  add(Emp emp){
        //根据员工的id，得到该员工应当添加到哪条链表,id取余后结果不同，放在不同的链表里面
        int empLinkListNo = hashFun(emp.id);

        empLinkedLists[empLinkListNo].add(emp);


    }
    public void list(){
        for (int i = 0; i < size; i++) {
            empLinkedLists[i].list(i+1);
        }
    }

    public int hashFun(int id){
        return id % size;
    }
}

class Emp{
    public int id;
    public String name;
    public Emp next; //next 是null

    public Emp(int id,String name) {
        this.id = id;
        this.name = name;
    }
}

class EmpLinkedList{
    private Emp head;
    //假定，当添加雇员时，id是自增长，即id的分配总是从小到大
    public void  add(Emp emp){
        if(head == null){
            head = emp;
            return;
        }
        Emp curEmp = head;
        while(true){
            if(curEmp.next == null){
                break;
            }
            curEmp = curEmp.next;
        }
        curEmp.next = emp;
    }
    //遍历雇员信息
    public void list(int no){
        if (head == null){
            System.out.println("第"+no+"条链表为空");
            return;
        }
        System.out.print("第"+no+"条链表的信息为");
        Emp curEmp = head;
        while (true){
            System.out.printf("=> id =%d name= %s\t",curEmp.id,curEmp.name);
            if (curEmp.next == null){
                break;
            }
            curEmp = curEmp.next;
        }
        System.out.println();
    }
}
