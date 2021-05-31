//堆排序原理：
//1、将无序序列构建成一个堆，根据升序降序需求选择大顶堆或小顶堆;
// 2、将堆顶元素与末尾元素交换，将最大元素"沉"到数组末端;
// 3、重新调整结构，使其满足堆定义，然后继续交换堆顶元素与当前末尾元素，反复执行调整+交换步骤，
// 直到整个序列有序。
// 对于升降排序就是不断循环构建大小顶堆，然后把最大（小）的数沉到数组最末端，用到树的思想，但没有写树，而是用的数组的形式
//
package com.chaoyue.java;

/**
 * @author chaoyue
 * @data2021-05-31 15:30
 */
public class HeapSort {
    public static void main(String[] args) {
        int arr[] = {4,6,8,5,9};

    }
    //堆排序方法
    public static void heapSort(int arr[]){
    }
