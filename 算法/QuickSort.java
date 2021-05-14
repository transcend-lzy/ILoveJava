package com.chaoyue.java;

import javax.xml.stream.events.StartDocument;
//找基准，递归排序，更新头尾--找基准，递归排序，更新头尾--直到尾比头小
/**
 * @author chaoyue
 * @data2021-05-14 21:31
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {-9,78,0,23,-567,70, -1,900, 4561};
    }
    public static void quickSort(int[] arr,int start,int end) {
        //把数组中的第0个数字作为标准数
        if (start < end) {
            int stard = arr[start];

            int l = start;//一开始是最左边
            int r = end;//一开始是最右边
            int temp = 0;
            //while循环的目的是让比pivot值小的放到左边，大的放到右边
            while (l < r) {
                while (l < r && stard <= arr[r]) {
                    r--;
                }
                arr[l] = arr[r];
                while (l < r && stard >= arr[l]) {
                    l++;
                }
                arr[r] = arr[l];

            }
            arr[l] = stard;
            quickSort(arr, start, l);
            quickSort(arr, l + 1, end);
        }
    }
}
