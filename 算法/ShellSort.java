package com.chaoyue.java;

/**
 * @author chaoyue
 * @data2021-05-10 14:54
 */
//i是当前要插入的元素，与同组的其他元素相比并交换
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
        //第三轮
        for (int i = 1; i < arr.length; i++) {
            for(int j = i - 1; j >= 0; j -= 1){
                if (arr[j] > arr[j+1]){
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
    //最终的希尔排序
    public static void shellSort1(int[] arr){
        int temp = 0;
        //第一轮
        for (int gap = arr.length /2; gap >0;gap /= 2){
            for (int i = gap; i < arr.length; i++) {
                for(int j = i -gap; j >= 0; j -= gap){
                    if (arr[j] > arr[j+gap]){
                        temp = arr[j];
                        arr[j] = arr[j+gap];
                        arr[j+gap] = temp;
                    }
                }
            }
        }
    }

    //插入排序
    public static void InsertSort(int[] arr){
        int insertVal = 0;
        int insertIndex = 0;

        for (int i = 1; i < arr.length; i++) {
            insertVal = arr[i];
            insertIndex = i-1;
            while (insertIndex >=0 && insertVal < arr[insertIndex]){
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            if (insertIndex + 1 != i){
                arr[insertIndex + 1] = insertVal;
            }
        }
    }
}

