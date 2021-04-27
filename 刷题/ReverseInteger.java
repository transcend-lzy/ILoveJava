package leetcode.editor.cn;

//给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。 
//
// 如果反转后整数超过 32 位的有符号整数的范围 [−231, 231 − 1] ，就返回 0。 
//假设环境不允许存储 64 位整数（有符号或无符号）。
//
// 
//
// 示例 1： 
//
// 
//输入：x = 123
//输出：321
// 
//
// 示例 2： 
//
// 
//输入：x = -123
//输出：-321
// 
//
// 示例 3： 
//
// 
//输入：x = 120
//输出：21
// 
//
// 示例 4： 
//
// 
//输入：x = 0
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// -231 <= x <= 231 - 1 
// 
// Related Topics 数学 
// 👍 2728 👎 0

import javax.print.DocFlavor;
import java.util.Arrays;

public class ReverseInteger{
public static void main(String[] args) {
Solution solution = new ReverseInteger().new Solution();
    System.out.println(solution.reverse(-2147483648));
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int reverse(int x) {
        Integer integer = x;
        String intStr = integer.toString();
        char[] chars = new char[intStr.length()];
        chars = intStr.toCharArray();
        int end = intStr.length()-1;
        int start = 0;
        char temp;

        while (chars[end] == '0'){

            end--;
            if (end < 0){
                return 0;
            }
        }
        chars = Arrays.copyOf(chars,end+1);
        if (chars[0] == '-'){
            start ++;
            while (start < end){
                temp = chars[start];
                chars[start] = chars[end];
                chars[end] = temp;
                start++;
                end--;
            }
        }else{
            while(start < end){
                temp = chars[start];
                chars[start] = chars[end];
                chars[end] = temp;
                start++;
                end--;
            }
        }
        intStr = new String(chars);
        if (Long.parseLong(intStr) > 214748364 || Long.parseLong(intStr) < -214748364){
            return 0;
        }else{
            return Integer.parseInt(intStr);
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}
