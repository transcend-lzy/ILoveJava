//希尔排序算法原理：希尔排序是把记录按下标的一定增量分组，对每组使用直接插入排序算法排序；随着增量逐渐减少，每组包含
//的关键词越来越多，当增量减至 1 时，整个文件恰被分成一组，算法便终止
//自身理解：希尔排序就是通过分组插入排序的方式，减少不必要的数据移动，从而提升插入排序的速度，算是对插入排序的优化和更新
package com.chaoyue.java;

/**
 * @author chaoyue
 * @data2021-05-10 14:54
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] arr = {101,34,119,1,-1,89};
    }
    public static void shellSort(int[] arr){
        int temp = 0;
        //第一轮
        for (int i = 5; i < arr.length; i++) {
            for(int j = i -5; j >= 0; j -= 5){
                if (arr[j] > arr[j+5]){
                    temp = arr[j];
                    arr[j] = arr[j+5];
                    arr[j+5] = temp;
                }
            }
        }
        //第二轮
        for (int i = 2; i < arr.length; i++) {
            for(int j = i - 2; j >= 0; j -= 2){
                if (arr[j] > arr[j+2]){
                    temp = arr[j];
                    arr[j] = arr[j+2];
                    arr[j+2] = temp;
                }
            }
        }
    }
       
}

