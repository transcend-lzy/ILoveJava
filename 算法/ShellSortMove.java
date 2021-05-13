package com.chaoyue.java;

/**
 * @author chaoyue
 * @data2021-05-13 21:56
 */
public class ShellSortMove {
    public static void main(String[] args) {
        int[] arr = new int[8];
        for (int i = 0; i < 8; i++) {
            arr[i] = (int)(Math.random()*8);
        }
    }
    //移位式希尔排序进行优化
    public static void shellSort2(int[] arr){
        for (int gap = arr.length / 2; gap > 0  ; gap /= 2) {
            //从第gap个元素，逐个对其所在的组进行直接插入排序
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                int temp = arr[j];
                while (j - gap >= 0 && temp < arr[j - gap]){
                    arr[j] = arr[j - gap];
                    j -= gap;//找到了应该插入的位置
                }
                arr[j] = temp;
            }

        }
    }
}
