package com.chaoyue.java;

import java.security.PublicKey;

/**
 * @author chaoyue
 * @data2021-05-20 9:13
 */
//前中后序遍历都是从根节点开始，其最主要的区别就是根节点输出的时间不同
// 前序遍历：1、先输出根节点  2、如果左子节点不为空，递归进行前序遍历 3、如果右子节点不为空，递归进行前序遍历
//中序遍历：1、如果左子节点不为空，递归进行中序遍历  2、输出当前根节点  3、如果右子节点不为空，递归进行中序遍历
//后序遍历： 1、如果左子节点不为空，递归进行后序遍历  2、如果右子节点不为空，递归进行后序遍历  3、输出当前根节点
public class BinaryTreeDemo {
    public static void main(String[] args) {

        HeroNode chaoyue = new HeroNode(1, "chaoyue");
        HeroNode wangling = new HeroNode(2, "wangling");
        HeroNode fife = new HeroNode(3, "fife");
        HeroNode didi = new HeroNode(4, "didi");

        //手动创建二叉树
        BinaryTree binaryTree = new BinaryTree(chaoyue);
        chaoyue.setLeft(wangling);
        chaoyue.setRight(fife);
        fife.setRight(didi);
        System.out.println("前序遍历");
        binaryTree.postOrder();
        //递归创建二叉树

    }

}

class BinaryTree{
    private HeroNode root;

    public BinaryTree(HeroNode root) {
        this.root = root;
    }

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    //前序遍历
    public void preOrder(){
        if(this.root != null){
            this.root.preOrder();
        }else {
            System.out.println("当前二叉树为空");
        }
    }
    //中序遍历
    public void infixOrder(){
        if(this.root != null){
            this.root.infixOrder();
        }else {
            System.out.println("当前二叉树为空");
        }
    }
    //后序遍历
    public void postOrder(){
        if(this.root != null){
            this.root.postOrder();
        }else {
            System.out.println("当前二叉树为空");
        }
    }
}


class HeroNode{
    private int no;
    private String name;
    private HeroNode left;
    private HeroNode right;

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    //前序遍历
    //this表示当前正在调用这个方法的那个节点
    public void preOrder(){
        System.out.println(this);
        if (this.left != null){
            this.left.preOrder();
        }
        if(this.right != null){
            this.right.preOrder();
        }
    }
    //中序遍历
    public void infixOrder(){
        if (this.left != null){
            this.left.infixOrder();
        }
        System.out.println(this);
        if(this.right != null){
            this.right.infixOrder();
        }
    }
    //后序遍历
    public void postOrder(){
        if(this.left != null){
            this.left.postOrder();
        }
        if(this.right != null){
            this.right.postOrder();
        }
        System.out.println(this);
    }
}
