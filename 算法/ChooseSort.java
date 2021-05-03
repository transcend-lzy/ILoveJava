package com.chaoyue.java;

/**
 * @author chaoyue
 * @data2021-04-27 15:47
 */
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
