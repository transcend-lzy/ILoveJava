package com.chaoyue.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author chaoyue
 * @data2021-06-08 18:14
 */
public class HuffmanTree {
    public static void main(String[] args) {
        int arr[] = {13,7,8,3,29,6,1};
        Node root = creatHuffmanTree(arr);
        preOrder(root);
    }

    public static void preOrder(Node root){
        if(root != null){
            root.preOrder();
        }else{
            System.out.println("空树，不能遍历");
        }
    }
    public static Node creatHuffmanTree(int[] arr){
        //为操作方便，第一步先进行以下步骤
        /*
        1、遍历arr数组
        2、将arr的每个元素构成一个个Node
        3、将Node放入到ArrayList中
         */
        List<Node> nodes = new ArrayList<>();
        for (int value: arr){
            nodes.add(new Node(value));
        }

        //总体是一个循环的过程，一直循环到，nodes列表当中只剩下最后一个数
        //因为弄完两个结点就把这两个结点从列表删除出去，然后把他们的合加进来
        //列表剩的最后一个数就是最后两个结点的合
        while (nodes.size() > 1){
            //排序，从小到大
            Collections.sort(nodes);
            System.out.println("nodes =" + nodes);
            //取出根节点权值最小的两颗二叉树
            Node leftNode = nodes.get(0);//从小到大排序，这里就是0，如果从大到小排序，这里就是最后一个
            Node rightNode = nodes.get(1);
            Node parent = new Node(leftNode.value+rightNode.value);

            parent.left = leftNode;
            parent.right = rightNode;
            //将构成树的两个结点删除
            nodes.remove(leftNode);
            nodes.remove(rightNode);
            //将他们的合当作新节点的权值，并加入列表
            nodes.add(parent);
        }
        return nodes.get(0);
    }
}
