package leetcode.editor.cn;

import java.lang.management.BufferPoolMXBean;
import java.util.ArrayList;

/**
 * @author chaoyue
 * @data2021-08-19 15:26
 * 统一都是从小到大排序嗷
 */
public class sort {
    public static void main(String[] args) {
        int[] ints = new int[]{3,9,-1,10,20};

//        sort.mergeSort(ints,0,ints.length-1,new int[ints.length]);
        sort.heapSort(ints);
        for(int i : ints){
            System.out.print(i+ ", ");
        }
    }
    public static void bubble(int[] nums){  //冒泡排序 一个一个比
        boolean flag = false;
        for (int i = 0; i < nums.length-1; i++) {
            for (int j = 0; j < nums.length-i; j++) {
                if(j < nums.length-1 && nums[j] > nums[j+1]){
                    int temp = nums[j+1];
                    nums[j+1] = nums[j];
                    nums[j] = temp;
                    flag = true;
                }
            }
            if (flag == false){
                return;
            }
            flag = false;
        }
    }

    public static void selectSort(int[] nums){ //选择排序，每次选择数组中没排序的数字集合中的最大（小）值放在第一个没排序的位置

        for (int i = 0; i < nums.length; i++) {
            int min = nums[i];
            int minIndex = i;
            for (int j = i+1; j <nums.length ; j++) {
                if (min> nums[j]){
                    min = nums[j];
                    minIndex = j;
                }
                min = Math.min(min,nums[j]);
            }
            if( minIndex != i){
                nums[minIndex] = nums[i];
                nums[i] = min;
            }
        }
    }
    //把n个待排序的元素看成一个有序表和一个无序表，每次把无序表的第一个元素拿出来插到有序表的合适地方
    public static void insertSort(int[] nums){
        int insertVal =0;
        int insertIndex = 0;
        for (int i = 1; i < nums.length; i++) {
            insertVal = nums[i];
            insertIndex = i-1;
            while (insertIndex >= 0 && insertVal < nums[insertIndex]){
                nums[insertIndex+1] = nums[insertIndex];
                insertIndex--;
            }
            if (i != insertIndex+1){
                nums[insertIndex+1] = insertVal;
            }
        }
    }
    //希尔排序
    public static void shellSort(int[] nums){
        for (int gap = nums.length/2; gap > 0; gap/=2) {  //分多次进行插入排序
            for (int i = gap; i < nums.length; i++) { //进行插入排序，i之所以等于gap是因为每一组gap之前的那个数看成了有序表
                int insertVal = nums[i];
                int inserIndex = i-gap;
                while (inserIndex >= 0 && insertVal < nums[inserIndex]){
                    nums[inserIndex+gap] = nums[inserIndex];
                    inserIndex -= gap;
                }
                if (i != inserIndex + gap){
                    nums[inserIndex + gap] = insertVal;
                }
            }
        }
    }
    //快速排序,每次取一个数作为中间值，让大于中间值得都在左边，小于得都在右边，并向左右递归，直到左右得数组只剩下一个数字。
    public static void quickSort(int[] nums,int left,int right){
        if (left>= right){
            return;
        }
        int l = left;
        int r = right;
        int pivot = nums[l];
        while (l < r){
            while (l < r && nums[r] >= pivot){ //先在右边找比中间值小得数字
                //如果不加这个l<r容易造成数组越界，以最极端得右边都是大的为例，这样就会导致r= -1
                r--;
            }
            if(l < r){//找到之后把那个比中间值小得数组放到原本中间值得位置，现在r这个位置就相当于空了
                nums[l] = nums[r];
            }
            while (l<r && nums[l] <= pivot){//找左边比中间值大得数字
                l++;
            }
            if (l<r){//找到后放到原本空得r那个位置，放完后l这个位置就空了 ，或者l移动到r那个位置，l和r就重合了
                nums[r] = nums[l];
            }
        }
        nums[l] = pivot;//经过while循环，l位置肯定是空的，这时候把一开始得中间值放进去
        quickSort(nums,left,r-1);
        quickSort(nums,r+1,right);
    }
    //分治算法，把大的数组拆分成好多个小得数组，最小得数组就是长度为1得数组，不需要排序，合得时候保证每个小数组都是有顺序得
    public static void mergeSort(int[] nums,int left,int right,int[] temp){//分得部分
        if (left >= right){
            return;
        }
        int middle = (left + right)/2;
        mergeSort(nums,left,middle,temp); // 向左分解
        mergeSort(nums,middle+1,right,temp); // 向右分解
        merge(nums,right,left,middle,temp);
    }
    private static void merge(int[]nums,int right,int left,int middle,int[] temp){
        int l = left; //前一个数组得数组头
        int mid = middle; //另一个数组的数组头
        int t = 0; //temp数组得数组头
        for (int i = 0; i < right - l + 1; i++) {//构建temp数组
            temp[i] = nums[i+left];
        }
        while (l<= middle && mid+1 <= right){//分别比较两个数组得数组头，把小的那个放到temp里面去
            if(nums[l] <= nums[mid+1]){
                temp[t++] = nums[l++];
            }else{
                temp[t++] = nums[mid+1];
                mid++;
            }
        }
        while (l <= middle){  //有一个数组可能普遍比较大，没有全放进去，但是他本身已经是排好序得了，所以直接都放进去就行了
            temp[t++] = nums[l++];
        }
        while (mid+1 <= right){
            temp[t++] = nums[mid+1];
            mid++;
        }

        t = 0; //把temp数组的内容放到nums里面去
        while (left <= right){
            nums[left++] = temp[t++];
        }
    }
//    大顶堆，每个节点值都大于等于其左右子节点的值，小顶堆就是小于等于
    //堆排序，先把数组搞成大顶堆/小顶堆（从小到大排序就大顶堆），
    // 然后大顶堆根节点就是最大值，把这个根节点保存在数组最后，并不让他再去参与排序，再构建大顶堆，如此循环，直到只剩下一个点是最小值
    public static void heapSort(int[]nums){
        int temp = 0; //将大顶堆顶出来的最大数存到数组末尾时的中间变量
        for (int i = nums.length/2 -1; i >= 0 ; i--) { //构建一个所有非叶子节点都是大顶堆的大顶堆
            adjustHeap(nums,i,nums.length); //从下往上，从左到右构建
        }
        for (int i = nums.length-1; i > 0; i--) {
            temp = nums[i];//把大顶堆顶上来的数，和数组最后面的那个数互换，并从下次循环不考虑被换下去的大数了
            nums[i] = nums[0];
            nums[0] =  temp;
            adjustHeap(nums,0,i);
//            这里为什么只用了0，原因在于前面已经构建了一个所有非叶子节点都是大顶堆的大顶堆，这时候只要让被换上去的一个小的数，
//            找到它自己的位置，就能重新构建一个大顶堆。
        }
    }

    /**
     *
     * @param nums  要构建大顶堆的数组
     * @param i   构建大顶堆的数的根节点在数组中的序号
     * @param length  将哪一部分长度的数组构建成大顶堆
     */
    private static void adjustHeap(int[] nums,int i,int length){
        int temp = nums[i]; //先把当前的父节点值保存起来
        for (int j = 2*i +1; j < length; j++) {  //2*i+1是当前父节点的左子节点
            if (j+1 < length && nums[j] < nums[j+1]){  //左子节点和右子节点进行比较，保存大的那个
                j++;
            }
            if (nums[j] > temp){//大的子节点和父节点比较，让大的当父节点
                nums[i] = nums[j];
                nums[j] = temp;
                i = j;//把j是子节点的序号，同时也是下一轮比较的父节点
            }else{
                break;//因为是从下往上比较的，所以一旦temp都比当前最大的那个节点大了，就没必要再比了。
            }
        }
    }

    //
}
