package com.chaoyue.java;

import java.net.FileNameMap;

/**
 * @author chaoyue
 * @data2021-05-17 9:12
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1,8,1,89,1000,1234};
        int resIndex = binarySearch(arr,0,arr.length-1,88);
        System.out.println(resIndex);
    }

    //二分查找

    /**
     *
     * @param arr 数组
     * @param left 左边索引
     * @param right 右边索引
     * @param findVal 要找的值
     * @return 找到就返回下标，没找到就返回-1
     */
    public static int binarySearch(int[] arr,int left,int right,int findVal){
        int mid = (left + right) / 2;
        int midval = arr[mid];
        if (left > right){
            return -1;
        }
        if (findVal > midval){
            return binarySearch(arr,mid + 1,right, findVal);
        }else if(findVal < midval){
            return binarySearch(arr,left,mid-1,findVal);
        }else{
            return mid;
        }
    }
}
