package com.chaoyue.java;

import com.sun.jdi.InconsistentDebugInfoException;

/**
 * @author chaoyue
 * @data2021-04-27 18:38
 */
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
