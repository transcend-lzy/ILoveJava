//01背包  每种东西只能放一次
public class test {
   public static void main(String[] args) {
       int m = 10; //背包得容量
       int[] w = {2, 3, 4, 7};//每个物体的重量
       int[] val = {1, 3, 5, 9};//每个物体的价值
       int n = w.length;//物体的数量
       int[] dp = new int[m + 1];
       for (int i = 1; i <= n; i++) {
           for (int j = m; j >=  w[i-1]; j--) {
//逆向递推,如果不是逆向递推，dp[j]就把dp[j-w[i-1]]冲了，因为01背包要用上一行的
                   dp[j] = Math.max(dp[j], dp[j-w[i-1]] + val[i-1]);
           }
       }

       System.out.println(dp[m]);

   }
}
