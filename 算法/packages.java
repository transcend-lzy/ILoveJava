//完全背包  每种东西的数量不限
public class test {
   public static void main(String[] args) {
       int m = 10; //背包得容量
       int[] w = {2, 3, 4, 7};//每个物体的重量
       int[] val = {1, 3, 5, 9};//每个物体的价值
       int n = w.length;//物体的数量
       int[] dp = new int[m + 1];
       for (int i = 1; i <= n; i++) {
           for (int j = w[i-1]; j <= m; j++) {
完全背包要用本行的数据，所以dp[j]一定要冲了dp[j-w[i-1]],所以一定要顺向递推
               dp[j] = Math.max(dp[j], dp[j-w[i-1]] + val[i-1]);
           }
       }
       System.out.println(dp[m]);

   }
}

//多重背包  限制每种东西的数量，就是01背包基础上，加一个循环
    //物品种类有5种
    //背包容量为1000
    //五种奖品占用空间为{80,40,30,40,20}
    //五种奖品的价值{20，50，50，30，20}
    //五种奖品购买的最多数量{4，9，7，6，1}
    //求最大价值
//多重背包朴素方法
public class test {
   public static void main(String[] args) {
       int m = 1000; //背包得容量
       int[] w = {80,40,30,40,20};//每个物体的重量
       int[] val = {20,50,50,30,20};//每个物体的价值
       int[] s = {4,9,7,6,1};
       int n = w.length;//物体的数量
       int[] dp = new int[m + 1];
       for (int i = 1; i <= n; i++) {
           for (int j = m; j >= w[i-1]; j--) {  //逆向递推
               for (int k = 0; k <= s[i-1]; k++) {
                   if (j >= k*w[i-1]){
                       dp[j] = Math.max(dp[j],dp[j-k*w[i-1]]+k*val[i-1]);
                   }
               }
           }
       }
       System.out.println(dp[m]);

   }
}

// 多重背包二进制方法,相当于把多个相同物体转换成了少个不同物体，每个不同物体等于多个相同物体
public class test {
   public static void main(String[] args) {
       int m = 1000; //背包得容量
       int[] w = {80,40,30,40,20};//每个物体的重量
       int[] val = {20,50,50,30,20};//每个物体的价值
       int[] s = {4,9,7,6,1};
       int n = w.length;//物体的数量
       int[] dp = new int[m + 1];
       int ans = 0;

       for (int i = 1; i <= n; i++) {
           LinkedList<Integer> ks = new LinkedList();
           for (int k = 1;k <= s[i-1];k*=2){
               s[i-1] -= k;
               ks.add(k);
           }
           if (s[i-1] > 0){
               ks.add(s[i-1]);
           }
           System.out.println(ks);
           for (int k = 0; k < ks.size(); k++) {  //将10个相同物品转化为几个重量和价值是原来多倍的物品，进行循环
               for (int j = m; j >=w[i-1]*ks.get(k) ; j--) {
                   dp[j] = Math.max(dp[j],dp[j-w[i-1]*ks.get(k)]+ks.get(k)*val[i-1]);
               }
           }
       }
       System.out.println(dp[m]);
   }
}
