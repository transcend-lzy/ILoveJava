package com.chaoyue.java;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author chaoyue
 * @data2021-05-16 21:20
 */

//稳定性排序：相同大小的数，排序前后的前后顺序是一致的
    //基数排序是一种高效的稳定性排序
public class radixSort {
    public static void main(String[] args) {
        int[] arr = {53,3,542,748,14,214};
        radix(arr);
    }
    public static void radixfen(int[] arr){
        //第一轮（针对每个元素的个位进行排序）
        //定义一个二维数组，表示十个桶，每个桶就是一个二维数组
        //二维数组包含10个一维数组，防止数据溢出，每一个一维数组，大小定位array.lenth
        int[][] bucket = new int[10][arr.length];


        //为记录每个桶中，实际存放了多少数据，我们定义一个一维数组来记录各个桶每次放入的数据个数
        //bucketElementCounts[0]就是bucket[0]桶放入的数据个数
        int[] bucketElementCounts = new int[10];

        for (int j = 0; j < arr.length; j++) {
            //取出每个元素的个位
            int digitOfElement = arr[j] %10;

            bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
            bucketElementCounts[digitOfElement]++;

        }

        int index = 0;
        for (int k = 0; k < bucketElementCounts.length; k++) {
            //桶中有数据才放入
            if(bucketElementCounts[k] != 0){
                //循环该桶即第k个桶（第k个一维数组），放入
                for (int m = 0; m < bucketElementCounts[m]; m++) {
                    arr[index++] = bucket[k][m];
                }
            }
            bucketElementCounts[k] = 0;
        }
        //第一轮处理后，需要将每个bucketElementCounts[k] = 0
        for (int j = 0; j < arr.length; j++) {
            //取出每个元素的个位
            int digitOfElement = arr[j]/10 %10;

            bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
            bucketElementCounts[digitOfElement]++;

        }

        index = 0;
        for (int k = 0; k < bucketElementCounts.length; k++) {
            //桶中有数据才放入
            if(bucketElementCounts[k] != 0){
                //循环该桶即第k个桶（第k个一维数组），放入
                for (int m = 0; m < bucketElementCounts[m]; m++) {
                    arr[index++] = bucket[k][m];
                }
            }
            bucketElementCounts[k] = 0;
        }
    }

    public static void radix(int[] arr){
        int[][] bucket = new int[10][arr.length];
        int[] bucketElementCounts = new int[10];
        //1、得到数组中最大的数的位数
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] > max){
                max = arr[i];
            }
        }
        System.out.println(max);
        int maxLength = (max + "").length();
        for (int i = 0,n = 1; i < maxLength; i++,n *= 10) {
            for (int j = 0; j < arr.length; j++) {
                //取出每个元素的个位
                int digitOfElement = arr[j] /n %10;

                bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
                bucketElementCounts[digitOfElement]++;

            }

            int index = 0;
            for (int k = 0; k < bucketElementCounts.length; k++) {
                //桶中有数据才放入
                if(bucketElementCounts[k] != 0){
                    //循环该桶即第k个桶（第k个一维数组），放入
                    for (int m = 0; m < bucketElementCounts[k]; m++) {
                        arr[index++] = bucket[k][m];
                    }
                    bucketElementCounts[k] = 0;
                }
            }
        }
        System.out.println("最终结果arr= " + Arrays.toString(arr));
    }

}
