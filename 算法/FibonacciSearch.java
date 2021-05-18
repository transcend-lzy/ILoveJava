package com.chaoyue.java;

import java.util.Arrays;

/**
 * @author chaoyue
 * @data2021-05-18 14:10
 */
//最难理解的地方在于，f[k] -1 = (f[k-1] -1) + (f[k-2] -1) +1; 加的1就是mid，同时前后又被分割成两个斐波那契数-1。
public class FibonacciSearch {
    public static void main(String[] args) {
        int [] arr = {1,8,10,89,1000,1234};
        System.out.println(fibSearch(arr, 891));
    }
    //需要用到斐波那契数列，所以要先写一个斐波那契数列,这里用非递归的方式
    public static int[] fib(int maxSize){
        int[] f = new int[maxSize];
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i < maxSize; i++) {
            f[i] = f[i-1] + f[i-2];
        }
        return f;
    }

    /**
     *
     * @param arr
     * @param key
     * @return
     */
    public static int fibSearch(int[] arr,int key){
       int low = 0;
       int high = arr.length-1;
       int k = 0;//表示斐波那契分割数值的下标
        int mid = 0;
        int[] f = fib(30);
        while (high > f[k] -1){
            k++;
        }
        //f[k]可能大于数组长度，因此需要构造一个新数组，指向a[]
        //新数组不足的部分会用0填充
        int[] temp = Arrays.copyOf(arr,f[k]);
        //实际上需要用arr最后的数填充temp
        for (int i = high + 1; i < temp.length; i++) {
            temp[i] = arr[high];
        }
        while (low <= high){
            mid = low + f[k-1] -1;
            if (key < temp[mid]){
                high = mid - 1;
                //这里减一是因为左边的元素数量是f[k-1]个
                k--;
            }else if (key > temp[mid]){
                low = mid + 1;
                //这里-2是因为右边的元素数量是f[k-2]个
                k -= 2;
            }else{
                if (mid <= high){
                    return mid;
                }else{
                    return high;
                }
            }
        }
        return -1;
    }

}

