package com.chaoyue.java;

import java.sql.SQLOutput;
import java.util.Arrays;

/**
 * @author chaoyue
 * @data2021-05-31 15:30
 */
public class HeapSort {
    public static void main(String[] args) {
        int arr[] = {4,6,8,5,9};
        heapSort(arr);

    }
    //堆排序方法
    public static void heapSort(int arr[]){
        int temp = 0;
        System.out.println("堆排序:");
        //第一个for循环是为了将原本无序得二叉树序列转换为大顶堆（若为从大到小排列则转换为小顶堆）
        for (int i = arr.length /2 - 1; i >= 0; i--) {
            adjustHeap(arr,i,arr.length);
        }
        System.out.println("数组是："+ Arrays.toString(arr));
        //这个for循环是在已经转换为大顶堆得前提下，不断将剩余数据构成得大顶堆中得最大数取出来
        //这里下面是从0开始得，是因为原本大顶堆已经构造好了，只有头部得数经过交换不符合大顶堆，所以从0开始找到0
        //这个序号得数，在新的大顶堆中得位置，并找到新的大顶堆的最大数
        for (int j = arr.length - 1; j > 0 ; j--) {
            temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            adjustHeap(arr,0,j);
            System.out.println("数组是："+ Arrays.toString(arr));
        }

        System.out.println("数组是："+ Arrays.toString(arr));

    }


    //将一个数组（二叉树），调整成一个大顶堆

    /**
     *将以i对应的非叶子结点的树调整为大顶堆
     * @param arr 待调整数组
     * @param i 表示非叶子结点在数组中的索引
     * @param length 表示对多少个元素继续调整，length逐渐减少
     */
    public static void adjustHeap(int arr[],int i ,int length){
        int temp = arr[i];
        //j =  i*2 +1  j是i的左子节点
        for (int j =  i*2 +1; j < length; j = j*2 +1) {
            if (j +1 < length && arr[j] < arr[j+1]){
                j++;
            }
            if(arr[j] > temp){
                arr[i] = arr[j];
                i = j;
            }else{
                break;
            }
        }
        arr[i] = temp;
        //for 循环结束，我们将以i为父节点得树得最大值，放在了最顶部
    }
}
