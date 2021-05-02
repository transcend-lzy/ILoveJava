package com.chaoyue.java;

import com.sun.jdi.InconsistentDebugInfoException;

/**
 * @author chaoyue
 * @data2021-04-27 18:38
 */
//把 n 个待排序的元素看成为一个有序表和一个无序表，开始时有
//序表中只包含一个元素，无序表中包含有 n-1 个元素，排序过程中每次从无序表中取出第一个元素，把它的排
//序码依次与有序表元素的排序码进行比较，将它插入到有序表中的适当位置，使之成为新的有序表。
public class InsertSort {
    public static void main(String[] args) {

    }
    public void insertSort(int[] array){
        int temp;
        int temp2;
        for (int i = 1; i < array.length; i++) {
            for(int j =0 ; j < i;j++){
                if (array[i] < array[j]){
                    temp = array[i];
                    array[i] = array[j];
                    array[i+1] = temp;
                    for(int index = i+1;index < array.length;index++){
                        temp2 = array[index+1];
                        array[index+1] = array[index];
                    }
                    break;
                }
            }
        }
    }
}
