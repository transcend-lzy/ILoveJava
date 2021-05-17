package com.chaoyue.java;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chaoyue
 * @data2021-05-17 10:03
 */
//有时一个数组里面要找的数不止一个，这时找到mid值以后，不要马上返回，而是向左和向右扫描，找到所有的findval，将索引保存在一个数组里面
public class BinarySearchNew {
    public static void main(String[] args) {
        int[] arr = {1,8,10,89,1000,1000,1234};
        ArrayList arrayList = binarySearch(arr,0,arr.length-1,100);
        System.out.println(arrayList);
    }

    /**
     *
     * @param arr
     * @param left
     * @param right
     * @param findVal
     * @return 返回一个包含所有要查找数的下标的数组
     */
    public static ArrayList binarySearch(int[] arr, int left, int right, int findVal){
        if (left > right){
            return new ArrayList<Integer>();
        }
        int mid = (left + right) /2;
        int midVal = arr[mid];
        if (findVal > midVal){
            return binarySearch(arr,mid + 1,right,findVal);
        }else if (findVal < midVal){
            return binarySearch(arr,left,mid -1 ,findVal);
        }else{
            List<Integer> resIndexList = new ArrayList<>();
            int temp = mid -1;
            while (true){
                if ( temp < 0 || arr[temp] != findVal){
                    break;
                }
                resIndexList.add(temp);
                temp -= 1;
            }
            resIndexList.add(mid);

            temp = mid +1;
            while (true){
                if ( temp > arr.length - 1 || arr[temp] != findVal){
                    break;
                }
                resIndexList.add(temp);
                temp += 1;
            }
            return (ArrayList) resIndexList;
        }
    }
}
