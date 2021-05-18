package com.chaoyue.java;

import java.util.Arrays;

/**
 * @author chaoyue
 * @data2021-05-18 13:48
 */
public class InsertVal {
    public static void main(String[] args) {
        int[] arr = new int[100];
        for (int i = 0; i < 100; i++) {
            arr[i] = i +1;
        }
        int index = insetValSearch(arr,0,arr.length-1,98);
        System.out.println(index);
        System.out.println(Arrays.toString(arr));
    }

    //插入查找

    /**
     *
     * @param arr
     * @param left
     * @param right
     * @param findVal
     * @return
     */
    public static int insetValSearch(int[] arr, int left,int right,int findVal){
        if (left > right || findVal < arr[0] || findVal > arr[arr.length -1 ]){
            return -1;
        }
        int mid = left + (right - left)*(findVal - arr[left])/(arr[right] - arr[left]);
        int midVal = arr[mid];
        if (findVal > midVal){
            return insetValSearch(arr,mid +1 ,right,findVal);
        }else if (findVal < midVal){
            return insetValSearch(arr,left,mid -1,findVal);
        }else{
            return mid;
        }
    }
}
