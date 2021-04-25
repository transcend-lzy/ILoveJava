package com.chaoyue.java;

/**
 * @author chaoyue
 * @data2021-04-25 18:30
 */
public class Quene8 {
    int max = 8;
    int[] array = new int[max];

    public static void main(String[] args) {

    }
    public void check(int n){
        if (n == max){
            print();
            return;
        }
        for(int i =0 ;i<n;i++){
            array[n] = i;
            if(judge(n)){
                check(n+1);
            }
        }
    }
    public boolean judge(int n){
        for (int i = 0;i<n;i++){
            return ((array[i] != array[n])&& Math.abs(n-i)!= Math.abs(array[n] - array[i]));
        }
        return true;
    }

    private void print(){
        for(int i = 0; i < max; i++){
            System.out.print(array[i]+" ");
        }
        System.out.println();
    }
}
