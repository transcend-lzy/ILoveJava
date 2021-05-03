package com.chaoyue.java;

/**
 * @author chaoyue
 * @data2021-04-27 15:47
 */
//选择排序（select sorting）也是一种简单的排序方法。它的基本思想是：第一次从 arr[0]~arr[n-1]中选取最小值，
//与 arr[0]交换，第二次从 arr[1]~arr[n-1]中选取最小值，与 arr[1]交换，第三次从 arr[2]~arr[n-1]中选取最小值，与 arr[2]
//交换，…，第 i 次从 arr[i-1]~arr[n-1]中选取最小值，与 arr[i-1]交换，…, 第 n-1 次从 arr[n-2]~arr[n-1]中选取最小值，
//与 arr[n-2]交换，总共通过 n-1 次，得到一个按排序码从小到大排列的有序序列。
public class ChooseSort {
    public static void main(String[] args) {
        ChooseSort chooseSort = new ChooseSort();
        chooseSort.chooseSort(new int[]{8,3,2,1,7,4,6,5});
    }
    public void chooseSort(int[] array){
        int min;
        int temp;
        int index =0;
        for (int i = 0; i < array.length; i++) {
            min = array[i];
            for(int j =i; j <array.length;j++){
                if (array[j] < min){
                    min = array[j];
                    index = j;
                }
            }
            temp = array[i];
            array[i] = min;
            array[index] = temp;
        }
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
