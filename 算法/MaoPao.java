package com.chaoyue.java;

/**
 * @author chaoyue
 * @data2021-04-27 15:30
 */
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

