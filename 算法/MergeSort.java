package com.chaoyue.java;

/**
 * @author chaoyue
 * @data2021-05-16 19:40
 */
//以这里的八个数为例，先递归分解和合并左面的4个数，再递归分解右边的四个数，最后合并8个数
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {8, 4, 5, 7, 1, 3, 6, 2};
        int[] temp = new int[arr.length];
        mergeSort(arr, 0, arr.length - 1, temp);
    }


    public static void mergeSort(int[] arr,int left, int right,int[] temp) {
        if (left < right){
            int mid = (left + right) / 2;
            //向左递归分解
            mergeSort(arr,left,mid,temp);
            //向右递归分解
            mergeSort(arr,mid + 1,right,temp);
            //合并
            merge(arr,left,mid,right,temp);

        }
    }

    /**
     * 合并的方法
     *
     * @param arr   排序原始数组
     * @param left  左边有序序列的初始索引
     * @param mid   右边有序数列的前一个参数
     * @param right 右边索引
     * @param temp  中间数组
     */
    public static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left;//初始化i，左边有序序列的初始索引
        int j = mid + 1;//初始化j，右边有序序列的初始索引
        int t = 0; //指向temp数组的当前索引
        //(一)
        //先把左右两边数据按照规则填充到temp数组
        //直到左右两边的有序序列，有一边处理完毕
        while (left <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[t] = arr[i];
                t++;
                i++;
            } else {
                temp[t] = arr[j];
                t++;
                j++;
            }
        }
        //(二)
        //把剩余数据的一边数据以此全部填到temp
        while (i <= mid) {
            temp[t] = arr[i];
            t++;
            i++;
        }
        while (j <= right) {
            temp[t] = arr[j];
            t++;
            j++;
        }
        //（三）
        //将temp数组的元素拷贝到arr
        //不是每次都拷贝所有
        t =0;
        int templeft = left;
        while(templeft <= right){
            arr[templeft] = temp[t];
            t += 1;
            templeft += 1;
        }
    }
}
