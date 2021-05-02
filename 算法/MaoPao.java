package com.chaoyue.java;

/**
 * @author chaoyue
 * @data2021-04-27 15:30
 */
//冒泡排序（Bubble Sorting）的基本思想是：通过对待排序序列从前向后（从下标较小的元素开始）,依次比较
//相邻元素的值，若发现逆序则交换，使值较大的元素逐渐从前移向后部，就象水底下的气泡一样逐渐向上冒。
public class MaoPao {
    public static void main(String[] args) {
        MaoPao maoPao = new MaoPao();
        maoPao.sortMao(new int[]{3,9,-1,10,20});
    }
    public void sortMao(int[] array){
        int temp;
        boolean flag;
        for (int i = 1; i < array.length; i++) {
            flag = false;
            for(int j = 0; j< array.length - i;j++){
                int current = array[j];
                int next = array[j+1];
                if (current > next){
                    flag =true;
                    temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
            if(!flag){
                System.out.println(i);
                break;
            }
        }
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}

