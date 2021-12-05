
import java.util.ArrayList;

public class Solution {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        if (k == 0) return new ArrayList<>();
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = input[i];
        }
        for (int i = k / 2 - 1; i >= 0; i--) {
            adjustHeap(res, k, i);
        }
        for (int i = k ; i < input.length; i++) {
            if (res[0] > input[i]) {
                res[0] = input[i];
                adjustHeap(res, k, 0);
            }
        }
        ArrayList<Integer> resArr = new ArrayList<>();
        for (int num : res) {
            resArr.add(num);
        }
        return resArr;
    }
    public void adjustHeap(int[] input, int len, int i) {  //构建小顶堆
        int temp = input[i];
        for (int j = 2 * i + 1; j < len; j = 2 * i + 1) {
            if (j + 1 < len && input[j] < input[j + 1]) j++;
            if (input[j] > temp) {
                input[i] = input[j];
                input[j] = temp;
                i = j;
            }else break;
        }
    }
}
